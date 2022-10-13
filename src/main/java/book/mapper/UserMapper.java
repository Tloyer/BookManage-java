package book.mapper;

import book.entity.User;
import book.model.UserModelForList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface UserMapper extends BaseMapper<User> {
    List<UserModelForList> getList();
}
