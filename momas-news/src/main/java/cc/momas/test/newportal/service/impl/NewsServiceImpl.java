package cc.momas.test.newportal.service.impl;

import java.util.List;

import cc.momas.test.newportal.dao.INewsDAO;
import cc.momas.test.newportal.entity.News;
import cc.momas.test.newportal.service.INewsService;
import cc.momas.test.newportal.utils.BeanFactory;
import cc.momas.test.newportal.utils.DBHelper;
import cc.momas.test.newportal.utils.Pager;

public final class NewsServiceImpl implements INewsService {
	private INewsDAO newsDao = (INewsDAO)BeanFactory.getBean("newsDao");

	/*   ****功能方法 **** */
	/**
	 * 添加新闻
	 */
	public int insert(News news) {
		return newsDao.insert(new DBHelper().getConnection(), news);
	}

	/**
	 * 删除新闻
	 * 
	 * @param id
	 *            新闻id
	 * @return
	 */
	public int delete(int id) {
		return newsDao.delete(new DBHelper().getConnection(), id );
	}

	public int update(News news) {
		return newsDao.update(new DBHelper().getConnection(), news);
	}

	public List<News> queryAll() {
		return newsDao.queryAll(new DBHelper().getConnection());
	}

	public News queryById(int id) {
		List<News> nList 
		= newsDao.queryByTj(
				new DBHelper().getConnection()
				,"SELECT * FROM news WHERE nid = ?"
				, new Object[] { id });
		return (nList != null && nList.size() > 0) ? nList.get(0) : null;
	}
	
	public Pager<News> queryByPager(Pager<News> pager){
		List<News> nList 
		= newsDao.queryByTj(
				new DBHelper().getConnection()
				,"SELECT * FROM news LIMIT ?,? "
				, new Object[]{pager.getFirstIndex(),pager.getPageSize()});
		pager.setList(nList);
		return pager;
	}
	
	public int queryCountAll(){		
		return newsDao.queryCountByTj(
				new DBHelper().getConnection()
				,"SELECT COUNT(0) FROM news "
				,null);
	}
	
}
