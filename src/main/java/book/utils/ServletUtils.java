package book.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author fanhongtao
 * 2022/10/13 15:35
 *
 * 封装原生request和response的一些处理逻辑
 */
public class ServletUtils {

    /**
     * 根据请求上下文拿到 RequestAttributes
     * @return
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 根据 RequestAttributes 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 根据 RequestAttributes 获取response
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }



    /**
     * 返回json内容到客户端
     *
     * @param response 渲染对象
     * @param obj   待返回的对象
     * @return null
     */
    public static void outJson(HttpServletResponse response, Object obj) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JsonUtils.obj2json(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
