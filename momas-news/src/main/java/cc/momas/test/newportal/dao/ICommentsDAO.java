/**
 * 
 */
package cc.momas.test.newportal.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.test.newportal.entity.Comments;

/**
 * CommentsDAO接口
 * 
 * @author sothe
 * 
 */
public interface ICommentsDAO {
	public int insert(Connection conn,Comments comments);

	public int delete(Connection conn,int id);

	public int update(Connection conn,Comments comments);

	public List<Comments> queryAll(Connection conn);

	public List<Comments> queryByTj(Connection conn, String sql, Object[] paras);

}
