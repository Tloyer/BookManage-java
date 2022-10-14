package book.service;

import book.entity.Book;
import book.entity.BookDetail;
import book.entity.UserLog;
import book.vo.PageRspData;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookService extends IService<Book> {

    PageRspData<Book> listByPage(Integer pageNum, Integer pageSize);

    void add(Book reqData);

    void borrowBook(Integer id);

    PageRspData<Book> searchByPage(Integer pageNum, Integer pageSize, String author, String bookName);
}
