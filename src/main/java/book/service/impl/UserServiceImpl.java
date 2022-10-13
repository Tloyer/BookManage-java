package book.service.impl;

import book.entity.User;
import book.entity.UsersRole;
import book.exception.BasicException;
import book.mapper.UserMapper;
import book.model.UserModelForList;
import book.service.UserService;
import book.service.UsersRoleService;
import book.vo.UserReqData;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UsersRoleService usersRoleService;

    @Override
    public List<UserModelForList> getList() {
        return this.baseMapper.getList();
    }
    @Transactional
    @Override
    public void register(UserReqData vo) {
        User existedUser = this.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, vo.getUsername()));
        if (existedUser != null) {
            throw new BasicException(HttpStatus.BAD_REQUEST.value(), "此用户名已存在");
        }
        User newUser = new User();
        newUser.setUserName(vo.getUsername());
        newUser.setHashedPassword(BCrypt.hashpw(vo.getPassword()));
        this.save(newUser);
        UsersRole ur = new UsersRole();
        ur.setUserId(newUser.getUserId());
        ur.setRoleId(vo.getRoleId());
        usersRoleService.save(ur);
    }
    @Transactional
    @Override
    public void manage(Integer id, String plainPassword) {
        User user = new User();
        user.setUserId(id);
        user.setHashedPassword(BCrypt.hashpw(plainPassword));
        this.updateById(user);
    }
    @Transactional
    @Override
    public String deleteRelated(Integer id) {
        usersRoleService.remove(Wrappers.<UsersRole>lambdaQuery().eq(UsersRole::getUserId, id));
        String name = getById(id).getUserName();
        this.removeById(id);
        return name;
    }
}
