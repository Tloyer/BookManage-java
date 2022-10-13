package book.service.impl;

import book.entity.UserLog;
import book.mapper.UserLogMapper;
import book.service.UserLogService;
import book.utils.ResultBody;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fanhongtao
 * 2022/10/13 15:32
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements UserLogService {

    @Transactional
    @Override
    public void deleteLogInfo(Integer logId) {
        this.removeById(logId);
    }


    @Override
    public ResultBody listByPage(int pageNum, int pageSize) {
        IPage<UserLog> userLogIPage = new Page<>(pageNum, pageSize);
        /* 根据时间降序排列 */
        LambdaQueryWrapper<UserLog> wrapper = Wrappers.<UserLog>lambdaQuery().orderByDesc(UserLog::getActionTime);
        // 分页
        userLogIPage = this.baseMapper.selectPage(userLogIPage, wrapper);
        // 构造结果
        HashMap<String, Object> map = new HashMap<>();
        List<UserLog> collect = userLogIPage.getRecords().stream().sorted((o1, o2) -> (int) (o2.getActionTime().getTime() - o1.getActionTime().getTime())).collect(Collectors.toList());
        map.put("records", collect);
        map.put("total", userLogIPage.getTotal());
        map.put("pages", userLogIPage.getPages());
        return ResultBody.success(map);
    }
}
