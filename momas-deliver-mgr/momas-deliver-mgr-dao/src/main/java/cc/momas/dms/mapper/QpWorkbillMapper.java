package cc.momas.dms.mapper;

import cc.momas.dms.pojo.QpWorkbill;
import cc.momas.dms.pojo.QpWorkbillExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QpWorkbillMapper {
    int countByExample(QpWorkbillExample example);

    int deleteByExample(QpWorkbillExample example);

    int deleteByPrimaryKey(Integer workbillId);

    int insert(QpWorkbill record);

    int insertSelective(QpWorkbill record);

    List<QpWorkbill> selectByExample(QpWorkbillExample example);

    QpWorkbill selectByPrimaryKey(Integer workbillId);

    int updateByExampleSelective(@Param("record") QpWorkbill record, @Param("example") QpWorkbillExample example);

    int updateByExample(@Param("record") QpWorkbill record, @Param("example") QpWorkbillExample example);

    int updateByPrimaryKeySelective(QpWorkbill record);

    int updateByPrimaryKey(QpWorkbill record);

    List<QpWorkbill> selectByPager(Pager<QpWorkbill, QpWorkbillExample> pager);
}