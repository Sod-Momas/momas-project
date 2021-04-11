package cc.momas.vote.dao;


import java.sql.Connection;
import java.sql.SQLException;

import cc.momas.vote.entity.VoteOption;

public interface IVoteOptionDAO extends IBaseDAO<VoteOption> {
	public int deleteByVoteId(Connection conn, Integer voteid) throws SQLException;
}
