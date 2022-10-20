package book.controller;

import book.entity.BorrowInfo;
import book.entity.Privilege;
import book.entity.UserStatus;
import book.exception.BasicException;
import book.service.BookService;
import book.service.BorrowInfoService;
import book.utils.ResultBody;
import book.utils.UserUtils;
import book.vo.BookSearchReqData;
import book.vo.BorrowInfoData;
import book.vo.BorrowInfoSearchData;
import book.vo.PageRspData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author fanhongtao
 * 2022/10/13 21:42
 */
@RestController
@RequestMapping("/borrow")
public class BorrowInfoController {

    @Autowired
    private BorrowInfoService borrowInfoService;

    @Autowired
    private BookService bookService;

    /**
     * 根据条件分页查询
     */
    @PostMapping("/search")
    public ResultBody searchByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   @RequestBody BorrowInfoSearchData query) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<BorrowInfo> pageRspData;
        if ("".equals(query.getBookName()) && "".equals(query.getUserName())) {
            pageRspData = borrowInfoService.listByPage(pageNum, pageSize);
        } else {
            pageRspData = borrowInfoService.searchByPage(pageNum, pageSize, query);
        }
        return ResultBody.success("查询成功", pageRspData);
    }

    //删除一个借书信息
    @DeleteMapping
    public ResultBody deleteDetail(@RequestBody BorrowInfoData borrowInfo) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        Integer bookId = borrowInfo.getBookId();
        Integer userId = borrowInfo.getUserId();
        boolean flag = borrowInfoService.deleteOne(userId, bookId);
        if (!flag) {
            throw new BasicException(400, "还书失败");
        }
        return ResultBody.success("还书成功");
    }

    //借一本书
    @PostMapping("/{id}")
    public ResultBody borrowBook(@PathVariable("id") Integer id, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户借书权限");
        UserStatus userStatus = (UserStatus) session.getAttribute(UserUtils.sessionStatusKey);
        Integer userId = userStatus.getUserId();
        String userName = userStatus.getUserName();
        boolean flag = borrowInfoService.borrowBook(id, userId, userName);
        if (!flag) {
            throw new BasicException(400, "借书失败");
        }
        return ResultBody.success("借书成功");
    }
}
