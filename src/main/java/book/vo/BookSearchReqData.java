package book.vo;

import lombok.Data;

import java.util.List;

/**
 * @author fanhongtao
 * @date 2022/10/15 19:31
 */
@Data
public class BookSearchReqData {
    private String bookName;

    private String bookAuthor;
}
