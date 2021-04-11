package cc.momas.test.newportal.service;

import java.util.List;

import cc.momas.test.newportal.dao.ITopicDAO;
import cc.momas.test.newportal.entity.Topic;

public interface ITopicService {
	/**
	 * 添加评论
	 */
	public int insert(Topic topic);

	/**
	 * 删除评论
	 * 
	 * @param id
	 *            新闻id
	 * @return
	 */
	public int delete(int id);

	public int update(Topic topic);

	public List<Topic> queryAll();

	public Topic queryById(int id);
	
}
