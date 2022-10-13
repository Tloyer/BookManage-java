package book.service.impl;

import book.entity.BookDetail;
import book.mapper.BookDetailMapper;
import book.service.BookDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class BookDetailServiceImpl extends ServiceImpl<BookDetailMapper, BookDetail> implements BookDetailService {

}
