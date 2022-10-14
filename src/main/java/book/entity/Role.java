package book.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("r_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;
}
