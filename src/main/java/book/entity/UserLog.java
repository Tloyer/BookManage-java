package book.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_log")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    private Integer userId;
    private Integer roleId;

    private Date actionTime;
    private Integer actionType;
    private String description;

    private String userName;
    private String roleName;
}
