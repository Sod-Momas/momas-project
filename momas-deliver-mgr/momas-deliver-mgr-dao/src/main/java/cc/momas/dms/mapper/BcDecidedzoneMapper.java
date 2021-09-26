package cc.momas.dms.mapper;

import cc.momas.dms.pojo.BcDecidedzone;
import cc.momas.dms.pojo.BcDecidedzoneExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BcDecidedzoneMapper {
    int countByExample(BcDecidedzoneExample example);

    int deleteByExample(BcDecidedzoneExample example);

    int deleteByPrimaryKey(Integer decidedzoneId);

    int insert(BcDecidedzone record);

    int insertSelective(BcDecidedzone record);

    List<BcDecidedzone> selectByExample(BcDecidedzoneExample example);

    BcDecidedzone selectByPrimaryKey(Integer decidedzoneId);

    int updateByExampleSelective(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByExample(@Param("record") BcDecidedzone record, @Param("example") BcDecidedzoneExample example);

    int updateByPrimaryKeySelective(BcDecidedzone record);

    int updateByPrimaryKey(BcDecidedzone record);

    List<BcDecidedzone> selectByPager(Pager<BcDecidedzone, BcDecidedzoneExample> pager);
}