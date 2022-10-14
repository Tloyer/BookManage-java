package book.service;

import book.entity.BookDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookDetailService extends IService<BookDetail> {

    void add(BookDetail reqData);

    BookDetail getBookDetail(Integer id);

    BookDetail updateBookDetail(BookDetail reqData);
}
