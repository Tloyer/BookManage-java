package book.service.impl;

import book.entity.Privilege;
import book.mapper.UserPrivilegeMapper;
import book.service.UserPrivilegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class UserPrivilegeServiceImpl extends ServiceImpl<UserPrivilegeMapper, Privilege> implements UserPrivilegeService {
}
