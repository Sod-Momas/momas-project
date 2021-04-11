package cc.momas.vote.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.entity.VoteOption;

public interface IVoteOptionService {
	
	public int add(VoteOption vo) throws NamingException, SQLException;
	
	public int delete(int voteId) throws NamingException, SQLException;
}
