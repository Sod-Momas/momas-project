package cc.momas.blog.dao;

import cc.momas.blog.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogDao {

    List<Log> getLogByStartAndLimit(@Param("start") Integer start, @Param("limit") Integer limit);

    int insertSelective(@Param("record") Log record);

    int deleteLogByIds(@Param("tagIds") Integer[] tagIds);

    int getLogCount();
}
