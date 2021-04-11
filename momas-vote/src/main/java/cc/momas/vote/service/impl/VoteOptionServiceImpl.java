package cc.momas.vote.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.dao.IVoteOptionDAO;
import cc.momas.vote.entity.VoteOption;
import cc.momas.vote.service.IVoteOptionService;
import cc.momas.vote.utils.BeanFactory;
import cc.momas.vote.utils.DBHelper;

public class VoteOptionServiceImpl implements IVoteOptionService {
	IVoteOptionDAO voDao = (IVoteOptionDAO) BeanFactory.getBean("voteOptionDao");
	Connection conn = null;

	public int add(VoteOption vo) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = voDao.insert(conn, vo);
		DBHelper.close(null, null, null, conn);
		return count;
	}

	public int delete(int voteId) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = voDao.deleteByVoteId(conn, voteId);
		DBHelper.close(null, null, null, conn);
		return count;
	}
	

}
