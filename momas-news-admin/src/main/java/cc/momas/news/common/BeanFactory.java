package cc.momas.news.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cc.momas.news.dao.impl.CategoryDaoImpl;
import cc.momas.news.dao.impl.CommentDaoImpl;
import cc.momas.news.dao.impl.NewsDaoImpl;
import cc.momas.news.dao.impl.UserDaoImpl;
import cc.momas.news.service.impl.CategoryServiceImpl;
import cc.momas.news.service.impl.CommentServiceImpl;
import cc.momas.news.service.impl.NewsServiceImpl;
import cc.momas.news.service.impl.UserServiceImpl;

/**
 * 工具类应该是不可被实例化的,抽象的
 * @author Sod-Momas
 *
 */
public abstract class BeanFactory {

	/**	单例工厂 */
	private static final Map<String, Object> factory = new ConcurrentHashMap<>(16);

	// 数据访问层对象
	public static final String DAO_USER = "dao_user";
	public static final String DAO_CATEGORY = "dao_category";
	public static final String DAO_NEWS = "dao_news";
	public static final String DAO_COMMENT = "dao_comment";
	
	// 业务层对象
	public static final String SERVICE_USER = "userService";
	public static final String SERVICE_CATEGORY = "service_category";
	public static final String SERVICE_NEWS = "service_news";
	public static final String SERVICE_COMMENT = "service_comment";
	
	static {
		// 先准备DAO,再准备service,因为Service中需要Dao
		// DAO
		factory.put(DAO_USER, new UserDaoImpl());
		factory.put(DAO_CATEGORY,new CategoryDaoImpl());
		factory.put(DAO_NEWS,new NewsDaoImpl());
		factory.put(DAO_COMMENT,new CommentDaoImpl());

		// service
		factory.put(SERVICE_USER, new UserServiceImpl());
		factory.put(SERVICE_CATEGORY, new CategoryServiceImpl());
		factory.put(SERVICE_NEWS, new NewsServiceImpl());	
		factory.put(SERVICE_COMMENT, new CommentServiceImpl());

	}

	public static Object getBean(String key) {
		return factory.get(key);
	}

//	未经检查的类型,很危险
//	@SuppressWarnings("unchecked")
//	public static <T> T get(String key) {
//		return (T) factory.get(key);
//	}
}
