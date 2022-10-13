package book.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("role_privilege")
public class Role2Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roleId;
    private Integer privilegeId;
}
