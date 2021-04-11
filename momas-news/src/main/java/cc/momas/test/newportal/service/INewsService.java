package cc.momas.test.newportal.service;

import java.util.List;

import cc.momas.test.newportal.dao.INewsDAO;
import cc.momas.test.newportal.entity.News;
import cc.momas.test.newportal.utils.Pager;

public interface INewsService {
	/**
	 * 添加新闻
	 */
	public int insert(News news);

	/**
	 * 删除新闻
	 * 
	 * @param id
	 *            新闻id
	 * @return
	 */
	public int delete(int id);

	public int update(News news);

	public List<News> queryAll();

	public News queryById(int id);
	
	public Pager<News> queryByPager(Pager<News> pager);
	
	public int queryCountAll();

	public INewsDAO getNewsDao();
	
	public void setNewsDao(INewsDAO newsDao);
	
}
