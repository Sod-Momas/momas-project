package cc.momas.momasjob;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
@RestController
@RequestMapping("job")
public class JobController {
    private AtomicLong idGenerator = new AtomicLong();

    @RequestMapping("ping")
    String ping() {
        return "pong";
    }

    /**
     * 初始化定时任务
     */
    @RequestMapping("init")
    String init() {
        JobContext.init();
        return "success";
    }

    /**
     * 添加一个定时任务
     *
     * @param info 任务信息
     * @return 添加的任务
     */
    @RequestMapping("add")
    Job add(@RequestBody Job info) {
        info.setId(idGenerator.incrementAndGet());
        info.setName(info.getName() + info.getId());
        info.setWasDone(false);
        info.setNextTime(info.getFirstTime().plus(info.getTimeValue(), info.getTimeUnit().toChronoUnit()));
        DataBase.add(info);
        return info;
    }

    @RequestMapping("del")
    Job del(@RequestParam("id")Long id) {
        return DataBase.deleteById(id);
    }

    /**
     * 销毁定时任务
     */
    @RequestMapping("destroy")
    String stopScanner() {
        JobContext.destroy();
        return "success";
    }
}
