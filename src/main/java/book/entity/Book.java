package book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("book")
public class Book {
    private static final long serialVersionUID = 1L;
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    private String bookName;//书名
    private String bookAuthor;//作者

    @TableField("isbn")
    private String ISBN;//ISBN
    private Integer stock;//库存
}
