package cc.momas.news.service.impl;

import cc.momas.news.common.BeanFactory;
import cc.momas.news.dao.CategoryDao;
import cc.momas.news.entity.Category;
import cc.momas.news.entity.User;
import cc.momas.news.service.AuthzException;
import cc.momas.news.service.CategoryService;
import cc.momas.news.service.ObjectNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static final CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean(BeanFactory.DAO_CATEGORY);

	@Override
	public List<Category> list() {
		String sql = "SELECT `id`,`parent_id`,`name`,`createtime`,`updatetime`,`status` FROM `category` ORDER BY `id` ASC";
		List<Category> list = categoryDao.list(sql);
		log.info("find {} rows data", list.size());
		return list;
	}

	@Override
	public void add(Integer parentId, String name, User oprator) {
		// 参数验证
		if (StringUtils.isBlank(name)) {
			throw new ObjectNotFoundException("分类名不能为空");
		}
		if (!oprator.getIsAdmin()) {
			throw new AuthzException("您没有权限,您配吗?");
		}
		if (null == parentId) {
			parentId = 0;
		}
		// sql
		String sql = "INSERT INTO `category` " + "(`id`, `parent_id`, `name`, `createtime`, `updatetime`, `status`) "
				+ "VALUES (null,?, ?, ?, ?, ?)";
		// 参数
		String[] params = { String.valueOf(parentId), name, getNowString(), getNowString(), String.valueOf(0) };
		// 返回值
		categoryDao.insert(sql, params);

	}

	@Override
	public void update(Integer id, Integer parentId, String name, Byte status, User oprator) {

		// 参数验证
		if (!oprator.getIsAdmin()) {
			// 非管理员操作
			throw new AuthzException("您没有权限,您配吗?");
		}

		// 参数
		List<String> paramList = new ArrayList<>();
		// sql
		String prefix = "UPDATE `news`.`category` SET";
		String suffix = " WHERE (`id` = ?) ";
		StringBuilder sql = new StringBuilder();

		if (null != parentId) {
			sql.append(" `parent_id` = ?");
			paramList.add(String.valueOf(parentId));
		}
		if (StringUtils.isNoneBlank(name)) {
			if (sql.length() > 0) {
				sql.append(",");
			}
			sql.append(" `name` = ?");
			paramList.add(name);
		}

		if (sql.length() > 0) {
			sql.append(",");
		}
		sql.append(" `updatetime` = ?");
		paramList.add(getNowString());

		if (null != status) {
			if (sql.length() > 0) {
				sql.append(",");
			}
			sql.append(" `status` = ?");
			paramList.add(status.toString());
		}

		paramList.add(id.toString());
		// 组装成完整 SQL
		sql.insert(0, prefix).append(suffix);

		// 返回值
		String[] arr = new String[paramList.size()];
		categoryDao.update(sql.toString(), paramList.toArray(arr));
	}

	@Override
	public void delete(Integer id, User oprator) {

		// 参数验证
		if (!oprator.getIsAdmin()) {
			// 非管理员操作
			throw new AuthzException("您没有权限,您配吗?");
		}
		// sql
		String sql = "DELETE FROM `category` WHERE id=?";
		// 返回值
		categoryDao.delete(sql, id);
	}

	/**
	 * 获取当前日期的字符串 例: "2018-10-04 09:55:41"
	 * 
	 * @return 当前时间字符串
	 */
	private String getNowString() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

}
