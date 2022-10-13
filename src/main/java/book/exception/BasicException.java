package book.exception;

import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Data
public class BasicException extends RuntimeException {

    private int code;
    private String msg;

    public BasicException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
