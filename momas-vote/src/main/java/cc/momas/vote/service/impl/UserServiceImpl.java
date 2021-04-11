package cc.momas.vote.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.dao.IUserDAO;
import cc.momas.vote.entity.User;
import cc.momas.vote.service.IUserService;
import cc.momas.vote.utils.BeanFactory;
import cc.momas.vote.utils.DBHelper;

public class UserServiceImpl implements IUserService {
	IUserDAO userDao = (IUserDAO) BeanFactory.getBean("userDao");
	Connection conn = null;

	public int register(User user) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = userDao.insert(conn, user);
		DBHelper.close(null, null, null, conn);
		return count;
	}

	public User login(String email, String password) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		User user = userDao.queryByTj(conn,
				"SELECT * FROM user WHERE uemail=? AND upassword=?",
				new Object[] { email, password }).get(0);
		DBHelper.close(null, null, null, conn);
		return user;
	}

	public int update(User user) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = userDao.update(conn, user);
		DBHelper.close(null, null, null, conn);
		return count;
	}

}
