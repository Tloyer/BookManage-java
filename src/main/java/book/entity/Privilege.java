package book.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
@Data
@TableName("privilege")
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "privilege_id", type = IdType.AUTO)
    private Integer privilegeId;

    private String privilegeName;

    public static final int PRI_READ = 1;
    public static final int PRI_EDIT = 2;
}
