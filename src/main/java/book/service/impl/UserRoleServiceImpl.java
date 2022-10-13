package book.service.impl;

import book.entity.Role;
import book.mapper.UserRoleMapper;
import book.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, Role> implements UserRoleService {
}
