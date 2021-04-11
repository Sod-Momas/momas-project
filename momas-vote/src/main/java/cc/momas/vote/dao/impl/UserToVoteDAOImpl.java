package cc.momas.vote.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cc.momas.vote.dao.IUserToVoteDAO;
import cc.momas.vote.entity.UserToVote;
import cc.momas.vote.utils.DBHelper;

public class UserToVoteDAOImpl extends BaseDAOImpl<UserToVote> implements
		IUserToVoteDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM usertovote WHERE uvid=?";
		int index = 0;
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, id);
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public int insert(Connection conn, UserToVote t) throws SQLException {
		String sql = "INSERT INTO usertovote(uid,vid) VALUES(?,?)";
		int index = 0;
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, t.getUid());
		ps.setInt(++index, t.getVid());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public List<UserToVote> queryAll(Connection conn) throws SQLException {
		UserToVote utov = null;
		List<UserToVote> uvList = new LinkedList<UserToVote>();
		String sql = "SELECT * FROM usertovote";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			utov = new UserToVote();
			utov.setUid(rs.getInt("uid"));
			utov.setUvid(rs.getInt("uvid"));
			utov.setVid(rs.getInt("vid"));
			uvList.add(utov);
		}
		DBHelper.close(ps, null, rs, null);
		return uvList;
	}

	@Override
	public List<UserToVote> queryByTj(Connection conn, String sql,
			Object[] paras) throws SQLException {
		UserToVote utv = null;
		List<UserToVote> utvList =new ArrayList<UserToVote>();
		ps = conn.prepareStatement(sql);
		ps = conn.prepareStatement(sql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				ps.setObject((i + 1), paras[i]);
			}
		}
		rs = ps.executeQuery();
		while(rs.next()){
			utv = new UserToVote();
			utv.setUid(rs.getInt("uid"));
			utv.setUvid(rs.getInt("uvid"));
			utv.setVid(rs.getInt("vid"));
			utvList.add(utv);
		}
		DBHelper.close(ps, null, rs, null);
		return utvList;
	}

	@Override
	public int update(Connection conn, UserToVote t) throws SQLException {
		String sql = "UPDATE usertovote SET uid=?,vid=? WHERE uvid=?";
		ps = conn.prepareStatement(sql);
		int index =0 ;
		ps.setInt(++index, t.getUid());
		ps.setInt(++index, t.getVid());
		ps.setInt(++index, t.getUvid());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

}
