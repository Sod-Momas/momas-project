package cc.momas.smbms.service;

import java.util.List;

import cc.momas.smbms.entity.User;

public interface IUserService {

	User login(User user);
	
	List<User> queryAll();
	
	int add(User user);

	int delete(User user);

	int update(User user);

	User queryById(Integer id);


}