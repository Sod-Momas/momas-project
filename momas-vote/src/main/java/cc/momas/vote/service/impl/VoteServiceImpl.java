package cc.momas.vote.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import cc.momas.vote.dao.IVoteDAO;
import cc.momas.vote.entity.Vote;
import cc.momas.vote.service.IVoteService;
import cc.momas.vote.utils.BeanFactory;
import cc.momas.vote.utils.DBHelper;

public class VoteServiceImpl implements IVoteService{
	IVoteDAO voteDao = (IVoteDAO) BeanFactory.getBean("voteDao");
	Connection conn = null;

	public int add(Vote vote) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = voteDao.insert(conn, vote);
		DBHelper.close(null, null, null, conn);
		return count;
	}
	
	public int delete(int vid) throws NamingException, SQLException{
		conn = new DBHelper().getConnection();
		int count = voteDao.delete(conn, vid);
		DBHelper.close(null, null, null, conn);
		return count;
	}

	public List<Vote> getAllList() throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		List<Vote> voteList = voteDao.queryAll(conn);
		DBHelper.close(null, null, null, conn);
		return voteList;
	}
}
