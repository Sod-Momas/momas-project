package cc.momas.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    /**
     * id
     */
    private Integer id;
    /**
     * 操作时间
     */
    private Date time;
    /**
     * 操作类型
     */
    private String type;
    /**
     * 详情
     */
    private String detail;
    /**
     * ip
     */
    private String ip;
}
