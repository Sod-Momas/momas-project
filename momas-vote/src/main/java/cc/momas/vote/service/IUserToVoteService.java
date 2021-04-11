package cc.momas.vote.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.entity.UserToVote;

public interface IUserToVoteService {
	public int add(UserToVote utv) throws NamingException, SQLException;
}
