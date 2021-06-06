package cc.momas.blog.service.Impl;

import cc.momas.blog.dao.LogDao;
import cc.momas.blog.dto.PageResult;
import cc.momas.blog.pojo.Log;
import cc.momas.blog.service.LogService;
import cc.momas.blog.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logMapper;

    @Override
    public PageResult getLogPage(Integer page, Integer limit) {
        List<Log> logList = logMapper.getLogByStartAndLimit((page - 1) * limit, limit);
        int count = logMapper.getLogCount(); // 获取总数
        return new PageResult(count, limit, page, logList);
    }

    @Override
    public void addLog(String type, String detail) {
        Log log = new Log();
        log.setDetail(detail);
        log.setIp(IpUtils.getIp());
        log.setTime(new Date());
        log.setType(type);
        logMapper.insertSelective(log);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return logMapper.deleteLogByIds(ids) > 0;
    }
}
