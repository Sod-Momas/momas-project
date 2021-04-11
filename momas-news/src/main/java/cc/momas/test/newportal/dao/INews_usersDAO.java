/**
 * 
 */
package cc.momas.test.newportal.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.test.newportal.entity.News_users;

/**
 * News_userDAO接口
 * 
 * @author sothe
 * 
 */
public interface INews_usersDAO  {
	public int insert(Connection conn,News_users News_users);

	public int delete(Connection conn ,int id);

	public int update(Connection conn, News_users News_users);

	public List<News_users> queryAll(Connection conn);

	public List<News_users> queryByTj(Connection conn, String sql, Object[] paras);
}
