package book.service.impl;

import book.entity.BookDetail;
import book.exception.BasicException;
import book.mapper.BookDetailMapper;
import book.service.BookDetailService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class BookDetailServiceImpl extends ServiceImpl<BookDetailMapper, BookDetail> implements BookDetailService {

    @Override
    @Transactional
    public void add(BookDetail reqData) {
        LambdaQueryWrapper<BookDetail> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(BookDetail::getISBN, reqData.getISBN());
        BookDetail bookDetail = this.getOne(wrapper);
        if (Objects.isNull(bookDetail)) {
            throw new BasicException(400, "图书详情信息已存在");
        }
        this.save(reqData);
    }

    @Override
    @Transactional
    public BookDetail updateBookDetail(BookDetail reqData) {
        BookDetail bookDetail = this.getById(reqData.getBookId());
        if (Objects.isNull(bookDetail)) {
            throw new BasicException(400, "图书详情信息不存在");
        }
        bookDetail.setIntroduction(reqData.getIntroduction());
        bookDetail.setImage(reqData.getImage());
        this.updateById(bookDetail);
        return bookDetail;
    }

    @Override
    public BookDetail getBookDetail(Integer id) {
        LambdaQueryWrapper<BookDetail> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(BookDetail::getBookId, id);
        BookDetail bookDetail = this.getOne(wrapper);
        if (Objects.isNull(bookDetail)) {
            throw new BasicException(400, "图书详情信息不存在");
        }
        return bookDetail;
    }
}
