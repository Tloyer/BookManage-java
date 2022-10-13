package book.vo;

import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Data
public class UserReqData {
    private String username;
    private String password;
    private Integer roleId;
}
