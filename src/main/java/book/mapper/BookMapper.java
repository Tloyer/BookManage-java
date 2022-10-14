package book.mapper;

import book.entity.Book;
import book.model.UserModelForList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BookMapper extends BaseMapper<Book> {
    Boolean borrowBook(@Param("Id") Integer Id);
}
