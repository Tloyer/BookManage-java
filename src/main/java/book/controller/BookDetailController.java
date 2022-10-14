package book.controller;

import book.entity.BookDetail;
import book.entity.Privilege;
import book.service.BookDetailService;
import book.utils.ResultBody;
import book.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/detail/")
public class BookDetailController {

    @Autowired
    private BookDetailService bookDetailService;

    //增加一本书的detail
    @PostMapping("/add")
    public ResultBody addDetail(@Validated @RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        bookDetailService.add(reqData);
        return ResultBody.success("增加成功");
    }

    //删除一本书的detail
    @DeleteMapping("/{Id}")
    public ResultBody deleteDetail(@PathVariable("Id") Integer Id, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        bookDetailService.removeById(Id);
        return ResultBody.success("删除成功");
    }

    //修改一本书的detail
    @PutMapping("/edit")
    public ResultBody editDetail(@Validated @RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权修改数据");
        BookDetail bookDetail = bookDetailService.updateBookDetail(reqData);
        return ResultBody.success("修改成功", bookDetail);
    }

    @GetMapping("/{Id}")
    public ResultBody getDetail(@PathVariable("Id") Integer Id) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        BookDetail bookDetail = bookDetailService.getBookDetail(Id);
        return ResultBody.success("查询成功", bookDetail);
    }
}
