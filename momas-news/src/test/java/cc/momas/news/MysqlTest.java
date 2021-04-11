package cc.momas.news;

import cc.momas.test.newportal.dao.impl.News_usersDAOImpl;
import cc.momas.test.newportal.entity.News_users;
import cc.momas.test.newportal.service.INews_usersService;
import cc.momas.test.newportal.service.impl.News_usersServiceImpl;
import cc.momas.test.newportal.utils.DBHelper;

import java.sql.*;

/**
 * @author Sod-Momas
 * @since 2021-04-11
 */
public class MysqlTest {

    private static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/news?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "sod";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        originSelect(args);
//        fromUtil();
        testLogin();
    }

    private static void testLogin() {
        String name = "sod";
        String pass = "sod";
        INews_usersService srv = new News_usersServiceImpl();
        News_users nu = srv.login(name, pass);
        System.out.println(nu);
    }

    private static void fromUtil() {
        try (final var connection = new DBHelper().getConnection()) {
            final var ps = connection.prepareStatement("SELECT 1 from news");
            final var resultSet = ps.executeQuery();
            while (resultSet.next()) {
                final var anInt = resultSet.getInt(1);
                System.out.println(anInt);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void originSelect(String[] args) {
        String sql = "SELECT 1";
        System.out.println(sql);
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement ps = connection.prepareStatement(sql, args)) {
            if (args != null && 0 < args.length) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            final var rs = ps.executeQuery();
            try {
                rs.next();
                System.out.println(rs.getInt(1));
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
