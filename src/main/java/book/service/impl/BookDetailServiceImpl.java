package book.service.impl;

import book.entity.BookDetail;
import book.exception.BasicException;
import book.mapper.BookDetailMapper;
import book.service.BookDetailService;
import book.utils.UploadUtils;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class BookDetailServiceImpl extends ServiceImpl<BookDetailMapper, BookDetail> implements BookDetailService {

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

    @Override
    @Transactional
    public boolean add(BookDetail reqData) {
        LambdaQueryWrapper<BookDetail> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(BookDetail::getBookId, reqData.getBookId());
        BookDetail bookDetail = this.getOne(wrapper);
        if (ObjectUtil.isNotNull(bookDetail)) {
            throw new BasicException(400, "图书详情信息已存在");
        }
        return this.save(reqData);
    }

    @Override
    @Transactional
    public boolean updateBookDetail(BookDetail reqData) {
        BookDetail bookDetail = this.getById(reqData.getBookId());
        if (Objects.isNull(bookDetail)) {
            throw new BasicException(400, "图书详情信息不存在");
        }
        return this.updateById(reqData);
    }

    @Override
    public void deleteImage(String image) {
        if (StringUtils.isNotBlank(image)) {
            System.out.println("删除图片:" + image);
            UploadUtils.removeFile(image);
        }
    }

    @Override
    @Transactional
    public String upload(MultipartFile file, String path, Integer id) {
        String fullPath = UploadUtils.uploadPicture(file, path);
        System.out.println("图片上传:" + fullPath);
        BookDetail bookDetail;
        if (id != null && id != 0) {
            bookDetail = this.getById(id);
            if (bookDetail == null) {
                throw new BasicException(HttpStatus.BAD_REQUEST.value(), "参数错误，不存在！");
            }
            bookDetail.setImage(fullPath);
            this.updateById(bookDetail);
        }
        return fullPath;
    }
}
