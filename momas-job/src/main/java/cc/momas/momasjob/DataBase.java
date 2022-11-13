package cc.momas.momasjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
public class DataBase {
    private static final Logger log = LoggerFactory.getLogger(DataBase.class);
    private static final List<Job> jobTable = new ArrayList<>();

    public static void add(Job info) {
        jobTable.add(info);
    }

    /**
     * @return 返回需要现在执行的任务
     */
    public static List<Job> getJobForExecute() {
        // 深拷贝，免得外层影响内层
        return jobTable.stream().filter(e -> {
            final LocalDateTime now = LocalDateTime.now();
            // 未执行过
            return !e.getWasDone()
                    // 第一次执行时间已经到达
                    && now.isAfter(e.getFirstTime())
                    // 下次执行时间已经到达
                    && now.isAfter(e.getNextTime());
        }).map(CloneUtil::deepCopy).toList();
    }


    public static void update(Job job) {
        final Long id = job.getId();
        jobTable.removeIf(e -> Objects.equals(e.getId(), id));
        jobTable.add(job);
    }

    public static Job deleteById(Long id) {
        final Iterator<Job> ite = jobTable.iterator();
        Job ret = null;
        while (ite.hasNext()) {
            final Job next = ite.next();
            if (next.getId().equals(id)) {
                ite.remove();
            }
            ret = next;
        }
        return ret;
    }
}
