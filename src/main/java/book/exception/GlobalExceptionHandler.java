package book.exception;

import book.utils.ServletUtils;
import book.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * @author fanhongtao
 * 2022/10/13 15:33
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //自定义异常
    @ExceptionHandler(BasicException.class)
    public ResultBody handlerBasicException(BasicException e) {
        e.printStackTrace();
        return ResultBody.error(e.getCode(), e.getMsg());
    }


    //处理 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultBody handlerNoFoundException(NoHandlerFoundException e) {
        HttpServletRequest request = ServletUtils.getRequest();
        log.error(e.getMessage());
        return ResultBody.error(HttpStatus.NOT_FOUND.value(), "请求 '" + request.getMethod() + " " + request.getRequestURI() + "' 不存在，请检查路径是否正确！");
    }


    //数据校验异常，表单格式接收数据
    @ExceptionHandler(BindException.class)
    public ResultBody validatedBindException(BindException e) {
        log.error(e.getMessage());
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return ResultBody.error(message);
    }


    //数据校验异常， json 格式接收数据，@RequestBody 标注
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBody validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResultBody.error(message);
    }

    //其他异常
    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(Exception e) {
        log.error("其他异常：{}", e);
        return ResultBody.error(e.getMessage());
    }
}
