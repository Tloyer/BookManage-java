package book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    //书名
    private String bookName;

    //作者
    private String bookAuthor;

    //ISBN
    @TableField("isbn")
    @JsonProperty("ISBN")
    private String ISBN;

    //库存
    private Integer stock;
}
