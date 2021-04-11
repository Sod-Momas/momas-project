package cc.momas.vote.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
	/**
	 * 用于多表查询
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数
	 * @return 查询结果
	 */
	public List<Object> combineQuery(Connection conn, String sql,Object[] params) throws SQLException ;

	/**
	 * 插入一个对象
	 * 
	 * @param conn
	 *            数据库连接
	 * @param t
	 *            对象
	 * @return
	 */
	public int insert(Connection conn, T t) throws SQLException ;

	/**
	 * 通过id删除一个对象
	 * 
	 * @param conn
	 *            数据库连接
	 * @param id
	 *            对象id
	 * @return 影响行数
	 */
	public int delete(Connection conn, int id) throws SQLException ;

	/**
	 * 更新一个对象
	 * 
	 * @param conn
	 *            数据库连接
	 * @param t
	 *            对象
	 * @return 影响行数
	 */
	public int update(Connection conn, T t) throws SQLException ;

	/**
	 * 查询本表中所有数据
	 * 
	 * @param conn
	 *            数据库连接
	 * @return 查询结果集
	 */
	public List<T> queryAll(Connection conn) throws SQLException ;

	/**
	 * 按条件查询数据
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            查询语句,参数用 <strong>?</strong>(英文问号)代替
	 * @param paras
	 *            参数列表,对应sql中的 ?
	 * @return 查询结果集
	 */
	public List<T> queryByTj(Connection conn, String sql, Object[] paras) throws SQLException ;

}
