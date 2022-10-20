package book.mapper;

import book.entity.Book;
import book.entity.BorrowInfo;
import book.entity.UserLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BorrowInfoMapper extends BaseMapper<BorrowInfo> {
    Boolean canBorrow(@Param("bookId") Integer bookId);
}
