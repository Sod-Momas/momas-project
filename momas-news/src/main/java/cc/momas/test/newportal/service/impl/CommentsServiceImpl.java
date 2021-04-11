package cc.momas.test.newportal.service.impl;

import java.util.List;

import cc.momas.test.newportal.dao.ICommentsDAO;
import cc.momas.test.newportal.entity.Comments;
import cc.momas.test.newportal.service.ICommentsService;
import cc.momas.test.newportal.utils.BeanFactory;
import cc.momas.test.newportal.utils.DBHelper;

public class CommentsServiceImpl implements ICommentsService {
	private ICommentsDAO cDao = (ICommentsDAO) BeanFactory.getBean("commentsDao");

	public int delete(int id) {
		return cDao.delete(new DBHelper().getConnection(),id);
	}

	public int insert(Comments comments) {
		return cDao.insert(new DBHelper().getConnection(), comments);
	}

	public List<Comments> queryAll() {
		return cDao.queryAll(new DBHelper().getConnection());
	}

	public Comments queryById(int id) {
		List<Comments> cList = cDao.queryByTj(
				new DBHelper().getConnection()
				, "SELECT * FROM comments WHERE cid = ?"
				,new Object[]{id} );
		return (cList != null && cList.size() > 0) ? cList.get(0) : null;

	}

	public int update(Comments comments) {
		return cDao.update(new DBHelper().getConnection(), comments);
	}


}
