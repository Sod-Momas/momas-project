package cc.momas.vote.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.dao.IUserToVoteDAO;
import cc.momas.vote.entity.UserToVote;
import cc.momas.vote.service.IUserToVoteService;
import cc.momas.vote.utils.BeanFactory;
import cc.momas.vote.utils.DBHelper;

public class UserToVoteServiceImpl implements IUserToVoteService {
	IUserToVoteDAO utvDao = (IUserToVoteDAO) BeanFactory.getBean("userToVoteDao");
	Connection conn = null;

	public int add(UserToVote utv) throws NamingException, SQLException {
		conn = new DBHelper().getConnection();
		int count = utvDao.insert(conn, utv);
		DBHelper.close(null, null, null, conn);
		return count;
	}
	
	
}
