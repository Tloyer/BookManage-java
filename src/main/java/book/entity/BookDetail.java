package book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("book_detail")
public class BookDetail {
    private static final long serialVersionUID = 1L;
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    private String ISBN;
    private String bookName;//书名
    private String bookAuthor;//作者
    private String publisher;
    private String time;//yyyy，如2017,
    private String image;//封面字符串
    private String introduction;//书籍简介
}
