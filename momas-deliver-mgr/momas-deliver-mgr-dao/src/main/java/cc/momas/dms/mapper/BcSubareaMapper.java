package cc.momas.dms.mapper;

import cc.momas.dms.pojo.BcSubarea;
import cc.momas.dms.pojo.BcSubareaExample;
import cc.momas.dms.pojo.ProvCount;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcSubareaMapper {
    int countByExample(BcSubareaExample example);

    int deleteByExample(BcSubareaExample example);

    int deleteByPrimaryKey(Integer subareaId);

    int insert(BcSubarea record);

    int insertSelective(BcSubarea record);

    List<BcSubarea> selectByExample(BcSubareaExample example);

    BcSubarea selectByPrimaryKey(Integer subareaId);

    int updateByExampleSelective(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

    int updateByExample(@Param("record") BcSubarea record, @Param("example") BcSubareaExample example);

    int updateByPrimaryKeySelective(BcSubarea record);

    int updateByPrimaryKey(BcSubarea record);

    List<BcSubarea> selectByPager(Pager<BcSubarea, BcSubareaExample> pager);

    /**
     * 查询饼图所需数据
     */
    List<ProvCount> selectSubareasGroupByProvince();

    //解除subArea与定区的关联
    int setDecidedzoneIdNull(Integer decidedzoneId);
}