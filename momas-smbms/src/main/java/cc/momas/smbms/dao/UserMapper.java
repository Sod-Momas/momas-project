package cc.momas.smbms.dao;

import java.util.List;

import cc.momas.smbms.entity.User;

public interface UserMapper {

	int count();

	List<User> queryAll();
	
	User queryById(Integer id);

	User queryByPassword(User user);
	
	int add(User user);

	int delete(User user);

	int update(User user);
}
