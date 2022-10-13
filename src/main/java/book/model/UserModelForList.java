package book.model;

import lombok.Data;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Data
public class UserModelForList {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private Integer roleId;
}
