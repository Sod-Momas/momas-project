/**
 * 
 */
package cc.momas.test.newportal.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.test.newportal.entity.News;

/**
 * @author sothe
 * 
 */
public interface INewsDAO {
	public int insert(Connection conn, News news);

	public int delete(Connection conn, int id);

	public int update(Connection conn, News news);

	/**
	 * 查询所有
	 */
	public List<News> queryAll(Connection conn);

	public List<News> queryByTj(Connection conn, String sql, Object[] paras);

	public int delete(Connection conn, String sql, Object[] paras);

	public int queryCountByTj(Connection conn, String sql,Object[] paras);

}
