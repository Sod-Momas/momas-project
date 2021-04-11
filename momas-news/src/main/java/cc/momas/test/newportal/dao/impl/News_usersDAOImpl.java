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

import cc.momas.test.newportal.dao.INews_usersDAO;
import cc.momas.test.newportal.entity.News_users;
import cc.momas.test.newportal.utils.DBHelper;

/**
 * @author sod
 * 
 */
public class News_usersDAOImpl implements INews_usersDAO {
	/**
	 * 查询所有
	 */
	public List<News_users> queryAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		News_users nu = null;
		List<News_users> nulist = new LinkedList<News_users>();

		try {
			ps = conn.prepareStatement("SELECT * FROM news_users");
			rs = ps.executeQuery();

			while (rs.next()) {
				nu = new News_users();
				nu.setUid(rs.getInt("uid"));
				nu.setUname(rs.getString("uname"));
				nu.setUpwd(rs.getString("upwd"));

				nulist.add(nu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return nulist;
	}

	public List<News_users> queryByTj(Connection conn, String sql, Object[] paras) {
		ResultSet rs = null;
		News_users nu = null;
		PreparedStatement ps = null;
		List<News_users> nulist = new LinkedList<News_users>();

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				nu = new News_users();
				nu.setUid(rs.getInt("uid"));
				nu.setUname(rs.getString("uname"));
				nu.setUpwd(rs.getString("upwd"));

				nulist.add(nu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return nulist;
	}

	/**
	 * 根据id删除记录
	 */
	public int delete(Connection conn, int id) {
		int count = -1;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(" DELETE FROM news_users WHERE uid = "
					+ id);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}

		return count;
	}

	public int insert(Connection conn, News_users news_users) {
		int count = -1;
		PreparedStatement ps = null;
		String sql = "INSERT INTO news_users VALUES(?,?,?)";

		try {
			ps = conn.prepareStatement(sql);

			int index = 0;
			ps.setObject(++index, news_users.getUid());
			ps.setObject(++index, news_users.getUname());
			ps.setObject(++index, news_users.getUpwd());
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

	public int update(Connection conn, News_users news_users) {
		String sql = "UPDATE news_users SET uid = uid";
		if (news_users.getUname() != null) {
			sql += " ,uname = '" + news_users.getUname() + "'";
		}
		if (news_users.getUpwd() != null) {
			sql += " ,upwd = '" + news_users.getUpwd() + "'";
		}
		sql += "WHERE uid = " + news_users.getUid();

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
