package book.service;

import book.entity.UsersRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface UsersRoleService extends IService<UsersRole> {
    UsersRole getByUserId(Integer userId);
}
