package book.service;

import book.entity.User;
import book.model.UserModelForList;
import book.vo.UserReqData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface UserService extends IService<User> {
    List<UserModelForList> getList();
    void register(UserReqData vo);
    void manage(Integer id, String plainPassword);
    /**
     * 删除指定的用户
     * @param id 用户 ID
     * @return 被删除的用户名
     */
    String deleteRelated(Integer id);
}
