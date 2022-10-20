package book.mapper;

import book.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookMapper extends BaseMapper<Book> {
    List<Book> searchByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                            @Param("bookAuthor") String bookAuthor, @Param("bookName") String bookName);

    boolean subOne(@Param("bookId") Integer bookId);
}
