/**
 * 
 */
package cc.momas.test.newportal.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.test.newportal.entity.Topic;

/**
 * @author sothe
 *
 */
public interface ITopicDAO {

	public int insert(Connection conn,Topic topic);

	public int delete(Connection conn,int id);

	public int update(Connection conn,Topic topic);

	public List<Topic> queryAll(Connection conn);

	public List<Topic> queryByTj(Connection conn, String sql, Object[] paras);

}
