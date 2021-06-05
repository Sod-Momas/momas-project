package cc.momas.smbms.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		Reader reader = null;
		try {
			String resource = "mybatis-config.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (IOException e) {
			System.err.println("myBatis配置文件读取失败");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public SqlSession getSession() {
		return sqlSessionFactory.openSession(false);
	}
	
	public SqlSession getSession(Boolean autocommit) {
		return sqlSessionFactory.openSession(autocommit);
	}
}
