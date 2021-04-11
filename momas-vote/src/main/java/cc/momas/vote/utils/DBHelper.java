package cc.momas.vote.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class DBHelper {
	private Connection conn;

	public DBHelper() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/vote");
		conn = ds.getConnection();
	}

	/** 用于获取数据库连接 */
	public Connection getConnection() {
		return this.conn;
	}

	/**
	 * 用于关闭资源
	 * 
	 * @param ps
	 *            预编译语句
	 * @param st
	 *            语句
	 * @param rs
	 *            结果集
	 * @param conn
	 *            数据库连接
	 * @throws SQLException 
	 */
	public static void close(PreparedStatement ps, Statement st, ResultSet rs,
			Connection conn) throws SQLException {
		if (ps != null) {
			ps.close();
		}
		if (st != null) {
			st.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
