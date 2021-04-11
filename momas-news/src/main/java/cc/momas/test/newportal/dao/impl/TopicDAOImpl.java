/**
 * 
 */
package cc.momas.test.newportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cc.momas.test.newportal.dao.ITopicDAO;
import cc.momas.test.newportal.entity.Topic;
import cc.momas.test.newportal.utils.DBHelper;

/**
 * @author sod
 * 
 */
public class TopicDAOImpl implements ITopicDAO {
	/**
	 * 删除话题
	 */
	public int delete(Connection conn, int id) {
		int count = 0;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(" DELETE FROM topic WHERE tid = " + id);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

	public int insert(Connection conn, Topic topic) {
		int count = -1;
		PreparedStatement ps = null;
		String sql = "INSERT INTO topic VALUES(?,?)";

		try {
			ps = conn.prepareStatement(sql);

			int index = 0;
			ps.setObject(++index, "NULL");// id自增
			ps.setObject(++index, topic.getTname());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null,null);
		}

		return count;
	}

	/**
	 * 查询所有
	 */
	public List<Topic> queryAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Topic topic = null;
		List<Topic> tlist = new LinkedList<Topic>();

		try {
			ps = conn.prepareStatement("SELECT * FROM topic");
			rs = ps.executeQuery();

			while (rs.next()) {
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));

				tlist.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return tlist;
	}

	public List<Topic> queryByTj(Connection conn, String sql, Object[] paras) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Topic topic = null;
		List<Topic> tlist = new LinkedList<Topic>();

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));

				tlist.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return tlist;
	}

	public int update(Connection conn, Topic topic) {
		String sql = "UPDATE topic SET tid = tid";// id自增
		if (topic.getTname() != null) {
			sql += " ,uname = '" + topic.getTname() + "'";
		}
		sql+=" WHERE tid = "+topic.getTid();
		
		PreparedStatement ps = null;
		int count = -1;

		try {
			ps = conn.prepareStatement(sql);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

}
