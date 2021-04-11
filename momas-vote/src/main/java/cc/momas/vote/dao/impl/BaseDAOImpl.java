package cc.momas.vote.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAOImpl<T> {

	public List<Object> combineQuery(Connection conn, String sql,
			Object[] params) throws SQLException {
		return null;
	}

	public abstract int delete(Connection conn, int id) throws SQLException ;

	public abstract int insert(Connection conn, T t) throws SQLException ;

	public abstract List<T> queryAll(Connection conn) throws SQLException;

	public abstract List<T> queryByTj(Connection conn, String sql, Object[] paras)
			throws SQLException ;

	public abstract int update(Connection conn, T t) throws SQLException ;
}
