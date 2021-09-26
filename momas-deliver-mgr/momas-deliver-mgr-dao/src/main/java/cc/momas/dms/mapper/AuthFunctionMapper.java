package cc.momas.dms.mapper;

import cc.momas.dms.pojo.AuthFunction;
import cc.momas.dms.pojo.AuthFunctionExample;
import cc.momas.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthFunctionMapper {
    int countByExample(AuthFunctionExample example);

    int deleteByExample(AuthFunctionExample example);

    int deleteByPrimaryKey(Integer authFuctionId);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    List<AuthFunction> selectByExample(AuthFunctionExample example);

    AuthFunction selectByPrimaryKey(Integer authFuctionId);

    int updateByExampleSelective(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByExample(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByPrimaryKeySelective(AuthFunction record);

    int updateByPrimaryKey(AuthFunction record);

    List<AuthFunction> selectByUserId(Integer userId);

    List<AuthFunction> selectAllFunctionByUserId(Integer userId);

    List<AuthFunction> selectByPager(Pager<AuthFunction, AuthFunctionExample> pager);
}