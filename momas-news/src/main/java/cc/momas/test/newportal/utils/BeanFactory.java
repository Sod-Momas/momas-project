package cc.momas.test.newportal.utils;

import java.util.HashMap;
import java.util.Map;

import cc.momas.test.newportal.dao.impl.CommentsDAOImpl;
import cc.momas.test.newportal.dao.impl.NewsDAOImpl;
import cc.momas.test.newportal.dao.impl.News_usersDAOImpl;
import cc.momas.test.newportal.dao.impl.TopicDAOImpl;
import cc.momas.test.newportal.service.impl.CommentsServiceImpl;
import cc.momas.test.newportal.service.impl.NewsServiceImpl;
import cc.momas.test.newportal.service.impl.News_usersServiceImpl;
import cc.momas.test.newportal.service.impl.TopicServiceImpl;

public final class BeanFactory {
	public static Map<String, Object> beans = new HashMap<String, Object>();
	static {
		// 先准备DAO,再准备service,因为Service中需要Dao
		beans.put("commentsDao", new CommentsDAOImpl());
		beans.put("news_usersDao", new News_usersDAOImpl());
		beans.put("newsDao", new NewsDAOImpl());
		beans.put("topicDao", new TopicDAOImpl());

		// service
		beans.put("news_usersService", new News_usersServiceImpl());
		beans.put("newsService", new NewsServiceImpl());
		beans.put("commentsService", new CommentsServiceImpl());
		beans.put("topicService", new TopicServiceImpl());

	}

	public static Object getBean(String key) {
		return beans.get(key);
	}

}
