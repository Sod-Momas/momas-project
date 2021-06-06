package cc.momas.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    //总记录数
    private int totalCount;
    //每页记录数
    private int pageSize;
    //当前页数
    private int currPage;
    //列表数据
    private List<?> list;
    //总页数
    private int totalPage;

    /**
     * 分页
     *
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     * @param list       列表数据
     */
    public PageResult(int totalCount, int pageSize, int currPage, List<?> list) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

}
