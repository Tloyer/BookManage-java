package book.controller;

import book.entity.BookDetail;
import book.entity.Privilege;
import book.exception.BasicException;
import book.service.BookDetailService;
import book.utils.ResultBody;
import book.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fantastic
 */
@RestController
@RequestMapping("/detail")
public class BookDetailController {

    @Autowired
    private BookDetailService bookDetailService;

    /**
     * 查询一本书的detail
     */
    @GetMapping("/{id}")
    public ResultBody getDetail(@PathVariable("id") Integer id) {
        UserUtils.checkPrivilege(Privilege.PRI_READ, "用户无权限查看数据");
        BookDetail bookDetail = bookDetailService.getBookDetail(id);
        return ResultBody.success("查询成功", bookDetail);
    }

    /**
     * 增加一本书的detail
     */
    @PutMapping
    public ResultBody addDetail(@RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        boolean flag = bookDetailService.add(reqData);
        if (!flag) {
            throw new BasicException(400, "增加失败");
        }
        return ResultBody.success("增加成功");
    }

    /**
     * 删除一本书的detail
     */
    @DeleteMapping("/{id}")
    public ResultBody deleteDetail(@PathVariable("id") Integer id) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        boolean flag = bookDetailService.removeById(id);
        if (!flag) {
            throw new BasicException(400, "删除失败");
        }
        return ResultBody.success("删除成功");
    }

    /**
     * 修改一本书的detail
     */
    @PostMapping
    public ResultBody editDetail(@Validated @RequestBody BookDetail reqData) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权修改数据");
        boolean flag = bookDetailService.updateBookDetail(reqData);
        if (!flag) {
            throw new BasicException(400, "修改失败");
        }
        return ResultBody.success("修改成功");
    }

    /**
     * 上传书的封面
     */
    @PostMapping("/upload")
    public ResultBody upload(@RequestPart MultipartFile file, @RequestParam("path") String path,
                             @RequestParam("id") Integer id, @RequestParam("image") String image) {
        UserUtils.checkPrivilege(Privilege.PRI_EDIT, "用户无权限修改数据");
        bookDetailService.deleteImage(image);
        String fullPath = bookDetailService.upload(file, path, id);
        return ResultBody.success("ok", fullPath);
    }
}
