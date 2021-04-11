package cc.momas.test.newportal.service.impl;

import java.sql.Connection;
import java.util.List;

import cc.momas.test.newportal.dao.INews_usersDAO;
import cc.momas.test.newportal.entity.News_users;
import cc.momas.test.newportal.service.INews_usersService;
import cc.momas.test.newportal.utils.DBHelper;

public class News_usersServiceImpl implements INews_usersService {
	private INews_usersDAO nuDao = null;

	/***** getter and setter ****/
	public INews_usersDAO getNuDao() {
		return nuDao;
	}

	public void setNuDao(INews_usersDAO nuDao) {
		this.nuDao = nuDao;
	}

	/**** 构造器 *****/
	public News_usersServiceImpl() {

	}

	public News_usersServiceImpl(INews_usersDAO news_usersDao) {
		this.nuDao = news_usersDao;
	}

	public int delete(int id) {
		return nuDao.delete(new DBHelper().getConnection(), id);
	}

	/**
	 * 登录方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 查询结果
	 */
	public News_users login(String username, String password) {
		String sql = "SELECT * FROM news_users WHERE uname = ? AND upwd = ?";
		System.out.println("hello");
		Object[] paras = { username, password };
		Connection conn=new DBHelper().getConnection();
		List<News_users> nuList = nuDao.queryByTj(conn, sql, paras);
		// if (nuList != null || nuList.size() > 0) {
		// return nuList.get(0);
		// }
		if (nuList == null || nuList.size() < 1) {
			return null;
		}
		return nuList.get(0);
	}

	public int insert(News_users nu) {
		return nuDao.insert(new DBHelper().getConnection(), nu);
	}

	public List<News_users> queryAll() {
		return nuDao.queryAll(new DBHelper().getConnection());
	}

	public News_users queryById(int id) {
		List<News_users> nuList = nuDao.queryByTj(new DBHelper()
				.getConnection(), "SELECT * FROM news_users WHERE uid = ",
				new Object[] { id });
		return nuList != null && nuList.size() > 0 ? nuList.get(0) : null;
	}

	public int update(News_users nu) {
		return nuDao.update(new DBHelper().getConnection(), nu);

	}
}
