package cc.momas.vote.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cc.momas.vote.dao.IVoteDAO;
import cc.momas.vote.entity.Vote;
import cc.momas.vote.utils.DBHelper;

public class VoteDAOImpl extends BaseDAOImpl<Vote> implements IVoteDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		int index = 0;
		String sql = "DELETE FROM vote WHERE vid=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, id);
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public int insert(Connection conn, Vote t) throws SQLException {
		int index = 0;
		String sql = "INSERT INTO vote(vtitle,vtype) VALUES(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(++index, t.getVtitle());
		ps.setInt(++index, t.getVtype());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public List<Vote> queryAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM vote";
		Vote vote = null;
		List<Vote> voteList = new LinkedList<Vote>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			vote = new Vote();
			vote.setVid(rs.getInt("vid"));
			vote.setVtitle(rs.getString("vtitle"));
			vote.setVtype(rs.getInt("vtype"));
			voteList.add(vote);
		}
		DBHelper.close(ps, null, rs, null);
		return voteList;
	}

	@Override
	public List<Vote> queryByTj(Connection conn, String sql, Object[] paras) throws SQLException {
		Vote vote = null;
		List<Vote> voteList = new ArrayList<Vote>();
		ps = conn.prepareStatement(sql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				ps.setObject((i + 1), paras[i]);
			}
		}
		rs = ps.executeQuery();
		while(rs.next()){
			vote = new Vote();
			vote.setVid(rs.getInt("vid"));
			vote.setVtitle(rs.getString("vtitle"));
			vote.setVtype(rs.getInt("vtype"));
			voteList.add(vote);
		}
		DBHelper.close(ps, null, rs, null);
		return voteList;
	}

	@Override
	public int update(Connection conn, Vote t) throws SQLException {
		String sql = "UPDATE vote SET vtitle=?,vtype=? WHERE vid=?";
		ps = conn.prepareStatement(sql);
		int index = 0;
		ps.setString(++index, t.getVtitle());
		ps.setInt(++index, t.getVtype());
		ps.setInt(++index, t.getVid());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

}
