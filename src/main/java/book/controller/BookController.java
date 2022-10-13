package book.controller;

import book.entity.Book;
import book.entity.BookDetail;
import book.entity.Privilege;
import book.utils.ResultBody;
import book.utils.UserUtils;
import book.vo.PageRspData;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author fanhongtao
 * 2022/10/13 20:35
 */
@RestController
@RequestMapping("/book/")
public class BookController {

    //分页查询所有书
    @PostMapping("/list")
    public ResultBody listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<Book> pageRspData = null;//查数据

        return ResultBody.success("查询成功");
    }

    //增加一本书的detail
    @PostMapping("/detail/add")
    public ResultBody addDetail(@Validated @RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限删除数据");

        return ResultBody.success("增加成功");
    }

    //删除一本书的detail
    @DeleteMapping("/detail/{Id}")
    public ResultBody deleteDetail(@PathVariable("Id") Integer Id, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限删除数据");

        return ResultBody.success("删除成功");
    }

    //修改一本书的detail
    @PutMapping("/detail/edit")
    public ResultBody editDetail(@Validated @RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改试验信息");

        return ResultBody.success("修改成功");
    }

    @GetMapping("/detail/{longId}")
    public ResultBody getOne(@PathVariable("Id") Integer Id) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        BookDetail bookDetail = null;//需要查

        return ResultBody.success(bookDetail);
    }
}
