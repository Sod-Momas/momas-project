package cc.momas.vote.utils;

import java.util.HashMap;
import java.util.Map;

import cc.momas.vote.dao.impl.UserDAOImpl;
import cc.momas.vote.dao.impl.UserToVoteDAOImpl;
import cc.momas.vote.dao.impl.VoteDAOImpl;
import cc.momas.vote.dao.impl.VoteOptionDAOImpl;
import cc.momas.vote.service.impl.UserServiceImpl;
import cc.momas.vote.service.impl.UserToVoteServiceImpl;
import cc.momas.vote.service.impl.VoteOptionServiceImpl;
import cc.momas.vote.service.impl.VoteServiceImpl;

public class BeanFactory {
	static Map<String, Object> map = new HashMap<String, Object>();

	static {
		map.put("userDao", new UserDAOImpl());
		map.put("userToVoteDao", new UserToVoteDAOImpl());
		map.put("voteDao", new VoteDAOImpl());
		map.put("voteOptionDao", new VoteOptionDAOImpl());
		
		map.put("userService", new UserServiceImpl());
		map.put("userToVoteService",new UserToVoteServiceImpl());
		map.put("voteOptionService",new VoteOptionServiceImpl());
		map.put("voteService", new VoteServiceImpl());
	}

	public static Object getBean(String name) {
		return map.get(name);
	}
}
