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

    private PageRspData<Book> pageQuery(Integer pageNum, Integer pageSize) {
        IPage<Book> page = new Page<>(pageNum, pageSize);
        // 分页
        page = this.baseMapper.selectPage(page, null);
        // 构造结果
        List<Book> records = page.getRecords();
        return PageRspData.of(records, page.getTotal(), page.getPages());
    }
}
