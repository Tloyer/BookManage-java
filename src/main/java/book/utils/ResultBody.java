package book.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author fanhongtao
 * 2022/10/13 15:35
 *
 * 返回结果类
 */
public class ResultBody extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public ResultBody() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public ResultBody(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResultBody(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 默认成功
     *
     * @return
     */
    public static ResultBody success() {
        return new ResultBody(HttpStatus.OK.value(), "操作成功", null);
    }

    /**
     * 携带成功消息和数据
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return
     */
    public static ResultBody success(String msg, Object data) {
        return new ResultBody(HttpStatus.OK.value(), msg, data);
    }



    /**
     * 只携带成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultBody success(String msg) {
        return ResultBody.success(msg, null);
    }

    /**
     * 只携带成功数据
     *
     * @return 成功消息
     */
    public static ResultBody success(Object data) {
        return ResultBody.success("操作成功", data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResultBody error(int code, String msg, Object data) {
        return new ResultBody(code, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResultBody error(int code, String msg) {
        return new ResultBody(code, msg);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResultBody error(String msg) {
        return ResultBody.error(HttpStatus.BAD_REQUEST.value(), msg);
    }

    /**
     * 默认错误消息
     *
     * @return 警告消息
     */
    public static ResultBody error() {
        return ResultBody.error(HttpStatus.BAD_REQUEST.value(), "操作失败！");
    }

}
