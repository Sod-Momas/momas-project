package cc.momas.news.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import java.sql.*;
import java.util.Properties;

public class DataSource {

    private static final Logger log = LoggerFactory.getLogger(DataSource.class);
    private static String username;
    private static String password;
    private static String jdbcUrl;

    /**
     * 获取一个数据库链接
     *
     * @return 数据库链接
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接失败, database connect error.", e);
        }
    }

    /**
     * 初始化数据库相关属性
     *
     * @param props 属性库
     * @see cc.momas.news.web.listener.ApplicationListener#contextInitialized(ServletContextEvent)
     */
    public static void init(Properties props) {
        try {
            Class.forName(props.getProperty(DataSourceConstant.DB_DRIVER_CLASS_NAME_KEY));
            username = (String) props.getOrDefault(DataSourceConstant.DB_USERNAME_KEY, DataSourceConstant.DEFAULT_USERNAME);
            password = (String) props.getOrDefault(DataSourceConstant.DB_PASSWORD_KEY, DataSourceConstant.DEFAULT_PASSWORD);
            jdbcUrl = (String) props.getOrDefault(DataSourceConstant.DB_JDBC_URL_KEY, DataSourceConstant.DEFAULT_JDBC_URL);
            testConnectDB();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动初始化失败, database driver init fail.", e);
        }
    }

    private static void testConnectDB() {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            prepareStatement = connection.prepareStatement("SELECT 1");
            resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                log.info("connecting database successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(prepareStatement);
            close(resultSet);
        }
    }

    private static void close(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception ignored) {
                // could not happen
            }
        }
    }

    /**
     * 数据库相关常量
     *
     * @author Sod-Momas
     * @since 2019.08.08
     */
    private interface DataSourceConstant {
        /**
         * 数据库驱动类名键名
         */
        String DB_DRIVER_CLASS_NAME_KEY = "momas.datasource.driver-name";
        /**
         * 数据库用户名键名
         */
        String DB_USERNAME_KEY = "momas.datasource.username";
        /**
         * 数据库密码键名
         */
        String DB_PASSWORD_KEY = "momas.datasource.password";
        /**
         * 数据库url键名
         */
        String DB_JDBC_URL_KEY = "momas.datasource.jdbc-url";
        /**
         * 默认的数据库用户名
         */
        String DEFAULT_USERNAME = "root";
        /**
         * 默认的数据库密码
         */
        String DEFAULT_PASSWORD = "123456";
        /**
         * 默认的jdbc链接
         */
        String DEFAULT_JDBC_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC";
    }
}