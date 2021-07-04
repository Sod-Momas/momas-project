package cc.momas.customer.service;

import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Users;
import cc.momas.customer.pojo.UsersExample;

public interface IUsersService {
 
	Users findLogin(Users user);

	Integer add(Users user);

	Pager<Users, UsersExample> queryByPager(Pager<Users, UsersExample> pager);

	int updateUser(Users user);

	Users queryById(Integer usersId);

	int delUserById(int id);
}