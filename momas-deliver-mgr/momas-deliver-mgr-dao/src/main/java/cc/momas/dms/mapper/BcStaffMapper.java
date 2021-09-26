package cc.momas.dms.mapper;

import cc.momas.dms.pojo.BcStaff;
import cc.momas.dms.pojo.BcStaffExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcStaffMapper {
    int countByExample(BcStaffExample example);

    int deleteByExample(BcStaffExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(BcStaff record);

    int insertSelective(BcStaff record);

    List<BcStaff> selectByExample(BcStaffExample example);

    BcStaff selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") BcStaff record, @Param("example") BcStaffExample example);

    int updateByExample(@Param("record") BcStaff record, @Param("example") BcStaffExample example);

    int updateByPrimaryKeySelective(BcStaff record);

    int updateByPrimaryKey(BcStaff record);

    List<BcStaff> selectByPager(Pager<BcStaff, BcStaffExample> pager);
}