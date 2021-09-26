package cc.momas.dms.mapper;

import cc.momas.dms.pojo.QpNoticebill;
import cc.momas.dms.pojo.QpNoticebillExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QpNoticebillMapper {
    int countByExample(QpNoticebillExample example);

    int deleteByExample(QpNoticebillExample example);

    int deleteByPrimaryKey(Integer noticebillId);

    int insert(QpNoticebill record);

    int insertSelective(QpNoticebill record);

    List<QpNoticebill> selectByExample(QpNoticebillExample example);

    QpNoticebill selectByPrimaryKey(Integer noticebillId);

    int updateByExampleSelective(@Param("record") QpNoticebill record, @Param("example") QpNoticebillExample example);

    int updateByExample(@Param("record") QpNoticebill record, @Param("example") QpNoticebillExample example);

    int updateByPrimaryKeySelective(QpNoticebill record);

    int updateByPrimaryKey(QpNoticebill record);

    List<QpNoticebill> selectByPager(Pager<QpNoticebill, QpNoticebillExample> pager);
}