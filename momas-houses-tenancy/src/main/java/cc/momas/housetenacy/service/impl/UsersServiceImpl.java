package cc.momas.housetenacy.service.impl;

import cc.momas.housetenacy.dao.IUsersDAO;
import cc.momas.housetenacy.entity.Users;
import cc.momas.housetenacy.service.IUsersService;
import cc.momas.housetenacy.utils.BeanFactory;
import org.hibernate.HibernateException;

public class UsersServiceImpl implements IUsersService {
	private IUsersDAO userDao = (IUsersDAO) BeanFactory.getBean("usersDao");

	public Users login(Users user) {
		try {
			user = userDao.queryByPwd(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}

		return user;
	}

	public boolean register(Users user) {
		boolean isSuccess = false;
		try {
			isSuccess = userDao.save(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
		}
		return isSuccess;
	}

}
