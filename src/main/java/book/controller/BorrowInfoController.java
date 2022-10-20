package book.controller;

import book.entity.BorrowInfo;
import book.entity.Privilege;
import book.service.BookService;
import book.service.BorrowInfoService;
import book.utils.ResultBody;
import book.utils.UserUtils;
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

    //分页查询所有借书信息
    @PostMapping("/list")
    public ResultBody listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<BorrowInfo> pageRspData = borrowInfoService.listByPage(pageNum, pageSize);
        return ResultBody.success("查询成功", pageRspData);
    }

    //根据条件分页查询
    @PostMapping("/search")
    public ResultBody searchByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "userName") String userName,
                                   @RequestParam(value = "bookName") String bookName) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<BorrowInfo> pageRspData = borrowInfoService.searchByPage(pageNum, pageSize, userName, bookName);
        return ResultBody.success("查询成功", pageRspData);
    }

    //删除一个借书信息
    //TODO:删除借书信息时库存自动+1
    @DeleteMapping
    public ResultBody deleteDetail(@RequestParam(value = "userId") Integer userId,
                                   @RequestParam(value = "bookId") Integer bookId) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");

        return ResultBody.success("删除成功");
    }

    //借一本书
    @GetMapping("/{id}")
    public ResultBody borrowBook(@PathVariable("id") Integer id) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        bookService.borrowBook(id);
        return ResultBody.success("借书成功");
    }
}
