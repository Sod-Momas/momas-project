package cc.momas.faker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 陈伟明
 * @since 2023/5/29
 */
@ShellComponent
public class TestSqlCommand extends AbstractShellComponent {
    private Logger log = LoggerFactory.getLogger(TestSqlCommand.class);

    @ShellMethod("Test Database connect.")
    public String testsql() throws SQLException {
        DataSource dataSource = getApplicationContext().getBean(DataSource.class);
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT 1");
        ) {

            if (rs.next()) {
                if (rs.getInt(1) == 1) {
                    return "connect OK.";
                }
            }
        } catch (Exception e) {
            log.warn("", e);
        }
        return "connect ERROR.";
    }

}
