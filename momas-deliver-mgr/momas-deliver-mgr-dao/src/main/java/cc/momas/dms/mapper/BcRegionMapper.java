package cc.momas.dms.mapper;

import cc.momas.dms.pojo.BcRegion;
import cc.momas.dms.pojo.BcRegionExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcRegionMapper {
    int countByExample(BcRegionExample example);

    int deleteByExample(BcRegionExample example);

    int deleteByPrimaryKey(Integer regionId);

    int insert(BcRegion record);

    int insertSelective(BcRegion record);

    List<BcRegion> selectByExample(BcRegionExample example);

    BcRegion selectByPrimaryKey(Integer regionId);

    int updateByExampleSelective(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByExample(@Param("record") BcRegion record, @Param("example") BcRegionExample example);

    int updateByPrimaryKeySelective(BcRegion record);

    int updateByPrimaryKey(BcRegion record);

    List<BcRegion> selectByPager(Pager<BcRegion, BcRegionExample> pager);
}