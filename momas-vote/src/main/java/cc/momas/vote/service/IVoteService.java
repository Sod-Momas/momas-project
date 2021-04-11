package cc.momas.vote.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import cc.momas.vote.entity.Vote;

public interface IVoteService {
	public int add(Vote vote) throws NamingException, SQLException ;
	
	public int delete(int vid) throws NamingException, SQLException;

	public List<Vote> getAllList() throws NamingException, SQLException;
}
