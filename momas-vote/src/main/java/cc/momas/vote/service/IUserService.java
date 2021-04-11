package cc.momas.vote.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import cc.momas.vote.entity.User;

public interface IUserService {
	public int register(User user) throws NamingException, SQLException;

	public User login(String email, String password) throws NamingException, SQLException;

	public int update(User user) throws NamingException, SQLException;
}
