package cc.momas.test.newportal.service.impl;

import java.util.List;

import cc.momas.test.newportal.dao.ITopicDAO;
import cc.momas.test.newportal.entity.Topic;
import cc.momas.test.newportal.service.ITopicService;
import cc.momas.test.newportal.utils.DBHelper;

public class TopicServiceImpl implements ITopicService {
	private ITopicDAO topicDao = null;

	/**** getter and setter *****/
	public ITopicDAO getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(ITopicDAO topicDao) {
		this.topicDao = topicDao;
	}

	/**** 构造方法 ****/
	public TopicServiceImpl() {
	}

	public TopicServiceImpl(ITopicDAO topicDao) {
		this.topicDao = topicDao;
	}

	/**** 功能方法 *****/
	public int delete(int id) {
		return topicDao.delete(new DBHelper().getConnection(), id);
	}

	public int insert(Topic topic) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Topic> queryAll() {
		return topicDao.queryAll(new DBHelper().getConnection());
	}

	public Topic queryById(int id) {
		List<Topic> tList =topicDao.queryByTj(
				new DBHelper().getConnection()
				, "SELECT * FROM topic WHERE tid ="
				, new Object[]{id});
		return (tList != null && tList.size() > 0) ? tList.get(0) : null;
	}

	public int update(Topic topic) {
		// TODO Auto-generated method stub
		return 0;
	}

}
