package book.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("u_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userName;//用户名

    @TableField(value = "password")
    private String hashedPassword;//加密后的密码

    private int age;//年龄
    private String sex;//性别

    private String phone;//电话
}
