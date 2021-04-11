package cc.momas.vote.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cc.momas.vote.dao.IVoteOptionDAO;
import cc.momas.vote.entity.VoteOption;
import cc.momas.vote.utils.DBHelper;

public class VoteOptionDAOImpl extends BaseDAOImpl<VoteOption> implements
		IVoteOptionDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM voteoption WHERE void=?";
		int index = 0;
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, id);
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	public int deleteByVoteId(Connection conn, Integer voteid) throws SQLException {
		String sql = "DELETE FROM voteoption WHERE vid=?";
		int index = 0;
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, voteid);
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}
	
	
	@Override
	public int insert(Connection conn, VoteOption t) throws SQLException {
		int index = 0;
		String sql = "INSERT INTO voteoption(vid,voname) VALUES(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(++index, t.getVid());
		ps.setString(++index, t.getVoname());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public int update(Connection conn, VoteOption t) throws SQLException {
		String sql = "UPDATE voteOption SET vid=?,voname=? WHERE void=?";
		ps = conn.prepareStatement(sql);
		int index = 0;
		ps.setInt(++index, t.getVid());
		ps.setString(++index, t.getVoname());
		ps.setInt(++index, t.getVoId());
		index = ps.executeUpdate();
		DBHelper.close(ps, null, rs, null);
		return index;
	}

	@Override
	public List<VoteOption> queryAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM voteoption";
		VoteOption vo = null;
		List<VoteOption> voList = new LinkedList<VoteOption>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			vo = new VoteOption();
			vo.setVid(rs.getInt("vid"));
			vo.setVoId(rs.getInt("voId"));
			vo.setVoname(rs.getString("voname"));
			voList.add(vo);
		}
		DBHelper.close(ps, null, rs, null);
		return voList;
	}

	@Override
	public List<VoteOption> queryByTj(Connection conn, String sql,
			Object[] paras) throws SQLException {
		VoteOption vo = null;
		List<VoteOption> voList = new ArrayList<VoteOption>();
		ps = conn.prepareStatement(sql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				ps.setObject((i + 1), paras[i]);
			}
		}
		rs = ps.executeQuery();
		while(rs.next()){
			vo = new VoteOption();
			vo.setVid(rs.getInt("vid"));
			vo.setVoId(rs.getInt("voId"));
			vo.setVoname(rs.getString("voname"));
			voList.add(vo);
		}
		DBHelper.close(ps, null, rs, null);
		return voList;
	}


}
