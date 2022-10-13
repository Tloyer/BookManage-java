package book.service;

import book.entity.UserLog;
import book.utils.ResultBody;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
public interface UserLogService extends IService<UserLog> {

    void deleteLogInfo(Integer logId);

    ResultBody listByPage(int pageNum, int pageSize);
}
