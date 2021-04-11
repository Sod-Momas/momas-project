/**
 * 
 */
package cc.momas.test.newportal.service;

import java.util.List;

import cc.momas.test.newportal.dao.ICommentsDAO;
import cc.momas.test.newportal.entity.Comments;

/**
 * @author sothe
 * 
 */
public interface ICommentsService {
	/**
	 * 添加评论
	 */
	public int insert(Comments comments);

	/**
	 * 删除评论
	 * 
	 * @param id
	 *            评论id
	 * @return
	 */
	public int delete(int id);

	public int update(Comments comments);

	public List<Comments> queryAll();

	public Comments queryById(int id);

}
