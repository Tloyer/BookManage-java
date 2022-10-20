package book.service;

import book.entity.Book;
import book.entity.BorrowInfo;
import book.entity.UserLog;
import book.vo.BookSearchReqData;
import book.vo.BorrowInfoSearchData;
import book.vo.PageRspData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface BorrowInfoService extends IService<BorrowInfo> {

    PageRspData<BorrowInfo> listByPage(Integer pageNum, Integer pageSize);

    PageRspData<BorrowInfo> searchByPage(Integer pageNum, Integer pageSize, BorrowInfoSearchData query);

    boolean borrowBook(Integer bookId, Integer userId, String userName);

    boolean deleteOne(Integer userId, Integer bookId);
}
