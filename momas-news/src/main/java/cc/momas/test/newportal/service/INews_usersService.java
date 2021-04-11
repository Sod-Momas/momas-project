/**
 * 
 */
package cc.momas.test.newportal.service;

import java.util.List;

import cc.momas.test.newportal.dao.INews_usersDAO;
import cc.momas.test.newportal.entity.News_users;

/**
 * @author sothe
 * 
 */
public interface INews_usersService {
	/**
	 * 添加用户
	 */
	public int insert(News_users nu);

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户id
	 * @return
	 */
	public int delete(int id);

	public int update(News_users nu);

	public List<News_users> queryAll();

	public News_users queryById(int id);
	
	public News_users login(String username, String password);
}
