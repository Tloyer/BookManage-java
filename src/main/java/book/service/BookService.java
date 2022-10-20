package book.service;

import book.entity.Book;
import book.vo.BookSearchReqData;
import book.vo.PageRspData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookService extends IService<Book> {

    PageRspData<Book> listByPage(Integer pageNum, Integer pageSize);

    PageRspData<Book> searchByPage(Integer pageNum, Integer pageSize, BookSearchReqData query);

    boolean add(Book reqData);

    boolean updateBook(Book reqData);

    void borrowBook(Integer id);
}
