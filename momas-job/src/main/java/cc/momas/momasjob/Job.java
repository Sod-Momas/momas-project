package cc.momas.momasjob;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
public class Job implements Serializable {
    private Long id;
    /**
     * 任务名
     */
    private String name;
    /**
     * 第一次开始时间
     */
    private LocalDateTime firstTime;
    /**
     * 下次执行时间
     */
    private LocalDateTime nextTime;
    /**
     * 时间值
     */
    private Long timeValue;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;
    /**
     * 任务是否已经完成
     */
    private Boolean wasDone;
//    /**
//     * 需要执行的任务
//     */
//    private String job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(LocalDateTime firstTime) {
        this.firstTime = firstTime;
    }

    public Long getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Long timeValue) {
        this.timeValue = timeValue;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Boolean getWasDone() {
        return wasDone;
    }

    public void setWasDone(Boolean wasDone) {
        this.wasDone = wasDone;
    }

    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }
}
