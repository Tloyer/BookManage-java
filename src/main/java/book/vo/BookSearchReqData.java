package book.vo;

import lombok.Data;

import java.util.List;

/**
 * @author wangwei
 * @date 2022/9/15 19:31
 * @description: TargetTestSearchReqData
 */
@Data
public class BookSearchReqData {
    private String bookName;

    private String bookAuthor;
}
