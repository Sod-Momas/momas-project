package cc.momas.news.common;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DaoTest {

    /**
     * 测试数据库连通性
     */
    @Test
    public void getConnectionTest() {
        Connection conn = DataSource.getConnection();
        System.out.println(conn);
        assertNotNull(conn);
    }

}
