package cc.momas.momasjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
public class JobContext {
    private static final Logger log = LoggerFactory.getLogger(JobContext.class);
    /**
     * 用于扫描定时任务的巡逻兵
     */
    private static Thread scanner = null;
    /**
     * 用于执行任务的线程池
     */
    private static volatile ExecutorService POOL = null;

    static void init() {
        if (scanner != null) {
            throw new RuntimeException("scanner is running");
        }
        if (POOL != null) {
            throw new RuntimeException("pool is running");
        }
        POOL = Executors.newSingleThreadExecutor();
        scanner = new Thread(() -> {
            while (true) {
                final Thread cur = Thread.currentThread();
                log.info("scanning jobs...");
                try {
                    // 100ms扫描一次任务
                    TimeUnit.MILLISECONDS.sleep(1000 - System.currentTimeMillis() % 100);
                } catch (InterruptedException e) {
                    log.warn("thread interrupted 001.", e);
                    return;
                }
                if (cur.isInterrupted()) {
                    log.warn("thread interrupted 002.");
                    return;
                }
                // 出取需要执行的任务
                Collection<Job> tasks = DataBase.getJobForExecute();
                for (Job job : tasks) {
                    if (cur.isInterrupted()) {
                        log.warn("thread interrupted 003.");
                        return;
                    }
                    // TODO 这里实现任务内容自定义
                    POOL.submit(() -> {
                        log.info(job.getName());
                        // TODO 这里使用回调处理任务
                        job.setWasDone(true);
                        DataBase.update(job);
                        // 生成一个新任务
                        final Job newJob = CloneUtil.deepCopy(job);
                        newJob.setWasDone(false);
                        newJob.setNextTime(LocalDateTime.now().plus(job.getTimeValue(), job.getTimeUnit().toChronoUnit()));
                        DataBase.add(newJob);
                    });
                }
            }
        });
        scanner.start();
    }

    static void destroy() {
        try {
            POOL.shutdownNow();
        } catch (Exception e) {
            log.error("stop executor error.", e);
        }
        try {
            scanner.interrupt();
            scanner.join();
        } catch (InterruptedException e) {
            log.error("stop scanner error.", e);
        }
        POOL = null;
        scanner = null;
    }
}
