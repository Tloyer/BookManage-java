package book.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
public class UserStatus implements Serializable {
    private Integer userId;
    private String userName;
    private Integer roleId;
    private String roleName;
    private Privilege[] privileges;
}
