package cc.momas.vote.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
	 */
	public static void close(AutoCloseable... closeable) {
		for (AutoCloseable c : closeable) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
