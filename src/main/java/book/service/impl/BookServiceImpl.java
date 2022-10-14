package book.service.impl;

import book.entity.Book;
import book.exception.BasicException;
import book.mapper.BookMapper;
import book.service.BookService;
import book.vo.PageRspData;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
        return pageQuery(pageNum, pageSize, null);
    }

    @Override
    public void add(Book reqData) {
        LambdaQueryWrapper<Book> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Book::getISBN, reqData.getISBN());
        Book book = this.getOne(wrapper);
        if (Objects.isNull(book)) {
            throw new BasicException(400, "图书信息已存在");
        }
        this.save(reqData);
    }

    @Override
    public void borrowBook(Integer id) {
        Boolean flag = baseMapper.borrowBook(id);
        if (!flag) {
            throw new BasicException(400, "借书失败");
        }
    }

    @Override
    public PageRspData<Book> search(String bookAuthor,String bookName) {
        LambdaQueryWrapper<Book> wrapper = Wrappers.lambdaQuery();
        List<Book> list = baseMapper.searchB
        return null;
    }

    private PageRspData<Book> pageQuery(Integer pageNum, Integer pageSize, Wrapper<Book> wrapper) {
        IPage<Book> page = new Page<>(pageNum, pageSize);
        // 分页
        page = this.baseMapper.selectPage(page, wrapper);
        // 构造结果
        List<Book> records = page.getRecords();
        return PageRspData.of(records, page.getTotal(), page.getPages());
    }
}
