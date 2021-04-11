/**
 * 
 */
package cc.momas.test.newportal.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 通用数据库工具
 * 
 * @author sothe
 * @version 2.0
 */
public final class DBHelper {
	private Connection conn = null;
//
//  <Resource
//	name="jdbc/connection"
//	auth="Container"
//	type="javax.sql.DataSource"
//	maxActive="100"
//	maxIdle="30"
//	maxWait="10000"
//	username="root"
//	password="root"
//	driverClassName="com.mysql.jdbc.Driver"
//	url="jdbc:mysql://localhost:3306/news?useUnicode=true&amp;characterEncoding=utf-8"/>
	
	/** 默认构造器 */
	public DBHelper() {
		//		try {
//			Context ctx = new InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("jdbc/connection");
//			this.conn = ds.getConnection();
//		} catch (NamingException e1) {
//			System.err.println("JNDI命名空间没有找到");
//			e1.printStackTrace();
//		} catch (SQLException e) {
//			System.err.println("数据库连接池获取连接失败");
//			e.printStackTrace();
//		}
//
//		if (this.conn == null) {
//            try {
//                Class.forName(className);
//            } catch (ClassNotFoundException e) {
//                System.err.println("mysql驱动类初始化没有找到");
//                e.printStackTrace();
//            }
//			try {
//				conn = DriverManager.getConnection(jdbcUrl, username, password);
//			} catch (SQLException e) {
//				System.err.println("数据库连接初始化失败");
//				e.printStackTrace();
//			}
//		}
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/connection");
			this.conn = ds.getConnection();
		} catch (NamingException e1) {
			System.err.println("JNDI命名空间没有找到");
			e1.printStackTrace();
		} catch (SQLException e) {
			System.err.println("数据库连接池获取连接失败");
			e.printStackTrace();
		}
	}

	/** 用于获取数据库连接 */
	public Connection getConnection() {
		return this.conn;
	}

    /** 用于关闭资源 */
    public static void close(PreparedStatement ps, Statement st, ResultSet rs,
                             Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // context.xml的配置内容
    // <Context>
    // <Environment name="tjndi" value="hello jndi" type="java.lang.String"/>
    // <Resource
    // name="jdbc/news"
    // auth="Container"
    // type="javax.sql.DataSource"
    // maxActive="100"
    // maxIdle="30"
    // maxWait="10000"
    // username="root"
    // password="root"
    // driverClassName="com.mysql.jdbc.Driver"
    // url="jdbc:mysql://localhost:3306/news?useUnicode=true&amp;characterEncoding=utf-8"/>
    //
    // </Context>
}
