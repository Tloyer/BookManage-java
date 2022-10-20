package book.service;

import book.entity.BookDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookDetailService extends IService<BookDetail> {

    BookDetail getBookDetail(Integer id);

    boolean add(BookDetail reqData);

    boolean updateBookDetail(BookDetail reqData);

    void deleteImage(String image);

    String upload(MultipartFile file, String path, Integer id);
}
