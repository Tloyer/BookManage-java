package book.service.impl;

import book.entity.Book;
import book.entity.BorrowInfo;
import book.exception.BasicException;
import book.mapper.BorrowInfoMapper;
import book.service.BorrowInfoService;
import book.vo.PageRspData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class BorrowInfoServiceImpl extends ServiceImpl<BorrowInfoMapper, BorrowInfo> implements BorrowInfoService {

    @Override
    public PageRspData<BorrowInfo> listByPage(Integer pageNum, Integer pageSize) {
        return pageQuery(pageNum, pageSize);
    }

    @Override
    public PageRspData<BorrowInfo> searchByPage(Integer pageNum, Integer pageSize, String userName, String bookName) {
        List<BorrowInfo> list = baseMapper.searchByPage(pageNum, pageSize, userName, bookName);
        if (Objects.isNull(list)) {
            throw new BasicException(400, "查询失败");
        }
        return PageRspData.of(list, pageNum, list.size());
    }

    private PageRspData<BorrowInfo> pageQuery(Integer pageNum, Integer pageSize) {
        IPage<BorrowInfo> page = new Page<>(pageNum, pageSize);
        // 分页
        page = this.baseMapper.selectPage(page, null);
        // 构造结果
        List<BorrowInfo> records = page.getRecords();
        return PageRspData.of(records, page.getTotal(), page.getPages());
    }
}
