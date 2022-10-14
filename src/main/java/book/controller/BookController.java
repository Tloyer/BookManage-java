package book.controller;

import book.entity.Book;
import book.entity.Privilege;
import book.service.BookService;
import book.utils.ResultBody;
import book.utils.UserUtils;
import book.vo.PageRspData;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookService bookService;

    //分页查询所有书
    @PostMapping("/list")
    public ResultBody listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<Book> pageRspData = bookService.listByPage(pageNum, pageSize);
        return ResultBody.success("查询成功", pageRspData);
    }

    @PostMapping("/search")
    public ResultBody searchByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "author") String author,
                                   @RequestParam(value = "bookName") String bookName) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        PageRspData<Book> pageRspData = bookService.searchByPage(pageNum, pageSize,author,bookName);
        return ResultBody.success("查询成功", pageRspData);
    }

    //增加书
    @PostMapping("/add")
    public ResultBody addBook(@Validated @RequestBody Book reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户权限修改数据");
        bookService.add(reqData);
        return ResultBody.success("增加成功");
    }

    //删除一本书的detail
    //TODO:删除书自动删除书的Detail，根据Id
    @DeleteMapping("/{Id}")
    public ResultBody deleteBook(@PathVariable("Id") Integer Id, HttpSession session) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        bookService.removeById(Id);
        return ResultBody.success("删除成功");
    }

    //借一本书
    @GetMapping("/borrow/{Id}")
    public ResultBody borrowBook(@PathVariable("Id") Integer Id) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权修改数据");
        bookService.borrowBook(Id);
        return ResultBody.success("借书成功");
    }
}
