package cc.momas.blog.dao;

import cc.momas.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
