package cc.momas.vote.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cc.momas.vote.dao.IUserDAO;
import cc.momas.vote.entity.User;
import cc.momas.vote.utils.DBHelper;

public final class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int insert(Connection conn, User t) throws SQLException {
		int index = 0;
		String sql = "INSERT INTO user(uid,uusername,upassword,uemail) VALUES(null,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(++index, t.getUusername());
		ps.setString(++index, t.getUpassword());
		ps.setString(++index, t.getUemail());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM user WHERE uid=?";
		int index = 0;
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, id);
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public int update(Connection conn, User t) throws SQLException {
		String sql = "UPDATE user SET uusername=?,upassword=?,uemail=? WHERE uid=?";
		ps = conn.prepareStatement(sql);
		int index = 0;
		ps.setString(++index, t.getUusername());
		ps.setString(++index, t.getUpassword());
		ps.setString(++index, t.getUemail());
		ps.setInt(++index, t.getUid());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public List<User> queryAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM user ";
		User user = null;
		List<User> userList = new ArrayList<User>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUemail(rs.getString("uemail"));
			user.setUid(rs.getInt("uid"));
			user.setUpassword(rs.getString("upassword"));
			user.setUusername(rs.getString("uusername"));
			userList.add(user);
		}
		DBHelper.close(ps, null, rs, null);
		return userList;
	}

	@Override
	public List<User> queryByTj(Connection conn, String sql, Object[] paras)
			throws SQLException {
		User user = null;
		List<User> userList = new ArrayList<User>();
		ps = conn.prepareStatement(sql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				ps.setObject((i + 1), paras[i]);
			}
		}
		rs = ps.executeQuery();
		while(rs.next()){
			user = new User();
			user.setUemail(rs.getString("uemail"));
			user.setUid(rs.getInt("uid"));
			user.setUpassword(rs.getString("upassword"));
			user.setUusername(rs.getString("uusername"));
			userList.add(user);
		}
		DBHelper.close(ps, null, rs, null);
		return userList;
	}

}
