package cc.momas.dms.mapper;

import cc.momas.dms.pojo.QpWorkordermanage;
import cc.momas.dms.pojo.QpWorkordermanageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QpWorkordermanageMapper {
    int countByExample(QpWorkordermanageExample example);

    int deleteByExample(QpWorkordermanageExample example);

    int deleteByPrimaryKey(Integer workordermanageId);

    int insert(QpWorkordermanage record);

    int insertSelective(QpWorkordermanage record);

    List<QpWorkordermanage> selectByExample(QpWorkordermanageExample example);

    QpWorkordermanage selectByPrimaryKey(Integer workordermanageId);

    int updateByExampleSelective(@Param("record") QpWorkordermanage record, @Param("example") QpWorkordermanageExample example);

    int updateByExample(@Param("record") QpWorkordermanage record, @Param("example") QpWorkordermanageExample example);

    int updateByPrimaryKeySelective(QpWorkordermanage record);

    int updateByPrimaryKey(QpWorkordermanage record);
}