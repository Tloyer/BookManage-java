package book.service.impl;

import book.entity.Book;
import book.entity.BorrowInfo;
import book.exception.BasicException;
import book.mapper.BookMapper;
import book.service.BookService;
import book.vo.BookSearchReqData;
import book.vo.PageRspData;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public PageRspData<Book> listByPage(Integer pageNum, Integer pageSize) {
        return pageQuery(pageNum, pageSize);
    }

    @Override
    public PageRspData<Book> searchByPage(Integer pageNum, Integer pageSize, BookSearchReqData query) {
        String bookName = query.getBookName();
        String bookAuthor = query.getBookAuthor();
        List<Book> list = baseMapper.searchByPage(pageNum, pageSize, bookAuthor, bookName);
        if (Objects.isNull(list)) {
            throw new BasicException(400, "查询失败");
        }
        return PageRspData.of(list, pageNum, list.size());
    }

    @Override
    @Transactional
    public boolean add(Book reqData) {
        LambdaQueryWrapper<Book> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Book::getISBN, reqData.getISBN());
        Book book = this.getOne(wrapper);
        if (ObjectUtil.isNotNull(book)) {
            throw new BasicException(400, "图书信息已存在");
        }
        return this.save(reqData);
    }

    @Override
    @Transactional
    public boolean updateBook(Book reqData) {
        Book book = this.getById(reqData.getBookId());
        if (Objects.isNull(book)) {
            throw new BasicException(400, "图书不存在");
        }
        return this.updateById(reqData);
    }

    @Override
    public boolean subOne(Integer bookId) {
        return this.baseMapper.subOne(bookId);
    }

    @Override
    @Transactional
    public int addAll(MultipartFile file) {
        int num = 0;
        Book book = new Book();
        try {
            InputStream bb = file.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(bb);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 0) {
                    break;
                }
                book.setBookName(temp[0].trim());
                book.setBookAuthor(temp[1].trim());
                book.setISBN(temp[2].trim());
                book.setStock(Integer.parseInt(temp[3].trim()));
                if (add(book)) {
                    num++;
                } else {
                    throw new BasicException(400, "上传失败");
                }
            }
            reader.close();
            bb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    private PageRspData<Book> pageQuery(Integer pageNum, Integer pageSize) {
        IPage<Book> page = new Page<>(pageNum, pageSize);
        // 分页
        page = this.baseMapper.selectPage(page, null);
        // 构造结果
        List<Book> records = page.getRecords();
        return PageRspData.of(records, page.getTotal(), page.getPages());
    }
}
