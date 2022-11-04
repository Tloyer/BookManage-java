package book.controller;

import book.entity.*;
import book.service.UserRoleService;
import book.service.UserRolesPrivilegeService;
import book.service.UserService;
import book.service.UsersRoleService;
import book.vo.UserReqData;
import book.enums.ActionType;
import book.utils.ResultBody;
import book.utils.UserUtils;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static book.utils.UserUtils.sessionStatusKey;

// https://github.com/spring-projects/spring-session/blob/main/spring-session-jdbc/src/main/resources/org/springframework/session/jdbc/schema-mysql.sql

/**
 * @author fanhongtao
 * 2022/10/13 21:42
 */
@RestController
@RequestMapping("/book/user")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UsersRoleService usersRoleService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserRolesPrivilegeService userRolesPrivilegeService;

    @PostMapping("/login")
    public ResultBody login(@RequestBody UserReqData vo, HttpSession session) {
        if (UserUtils.isLoggedIn(session)) {
            return ResultBody.success("已登录！", session.getAttribute(sessionStatusKey));
        }
        User user = service.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, vo.getUsername()));
        if (user == null) {
            return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "用户名或密码错误");
        }
        if (!BCrypt.checkpw(vo.getPassword(), user.getHashedPassword())) {
            return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "用户名或密码错误");
        }
        UsersRole usersRole = usersRoleService.getByUserId(user.getUserId());
        Role role = userRoleService.getById(usersRole.getRoleId());
        List<Privilege> privileges = userRolesPrivilegeService.getPrivilegesByRoleId(role.getRoleId());
        Privilege[] privilegeArr = new Privilege[privileges.size()];
        privileges.toArray(privilegeArr);
        UserStatus status = new UserStatus();
        status.setUserId(user.getUserId());
        status.setUserName(user.getUserName());
        status.setRoleId(role.getRoleId());
        status.setRoleName(role.getRoleName());
        status.setPrivileges(privilegeArr);
        session.setAttribute(sessionStatusKey, status);
        UserUtils.log(session, ActionType.LOGIN, "用户登录：" + user.getUserName());
        return ResultBody.success("登录成功！", status);
    }

    @GetMapping("/login/check")
    public ResultBody loginCheck(HttpSession session) {
        if (UserUtils.isLoggedIn(session)) {
            return ResultBody.success("已登录！", session.getAttribute(sessionStatusKey));
        }
        return ResultBody.error("未登录");
    }

    @PostMapping("/logout")
    public ResultBody logout(HttpSession session) {
        if (!UserUtils.isLoggedIn(session)) {
            return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "未登录");
        }
        UserStatus status = (UserStatus) session.getAttribute(sessionStatusKey);
        UserUtils.log(session, ActionType.LOGOUT, "用户退出登录：" + status.getUserName());
        session.removeAttribute(sessionStatusKey);
        return ResultBody.success("已退出登录！");
    }

    @PostMapping("/change-pwd")
    public ResultBody changePassword(@RequestBody UserReqData vo, HttpSession session) {
        if (!UserUtils.isLoggedIn(session)) {
            return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "未登录");
        }
        // 只允许修改自己的密码
        UserStatus status = (UserStatus) session.getAttribute(sessionStatusKey);
        if (!status.getUserName().equals(vo.getUsername())) {
            return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "只允许用户修改自己的密码");
        }
        service.manage(status.getUserId(), vo.getPassword());
        return ResultBody.success("成功");
    }

    @GetMapping("/list")
    public ResultBody list(HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限进行用户管理操作");
        return ResultBody.success(service.getList());
    }

    @PostMapping("/register")
    public ResultBody register(@RequestBody UserReqData vo, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限进行用户管理操作");
        service.register(vo);
        UserUtils.log(session, ActionType.INSERT, "新用户：" + vo.getUsername());
        return ResultBody.success("成功");
    }

    @DeleteMapping("/{id}")
    public ResultBody delete(@PathVariable("id") Integer id, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限进行用户管理操作");
        UserStatus status = (UserStatus) session.getAttribute(sessionStatusKey);
        if (status.getUserId().equals(id)) {
            return ResultBody.error(HttpStatus.FORBIDDEN.value(), "不能删除自己的账号");
        }
        String userName = service.deleteRelated(id);
        UserUtils.log(session, ActionType.DELETE, "用户：" + userName);
        return ResultBody.success("成功");
    }
}
