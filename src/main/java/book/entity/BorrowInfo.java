package book.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("borrow_info")
public class BorrowInfo {
    private Integer userId;
    private String userName;//用户名

    private Integer bookId;
    private String bookName;//书名

    private Long borrowTime;//借书时间
    private Long deadline;//应还时间
}
