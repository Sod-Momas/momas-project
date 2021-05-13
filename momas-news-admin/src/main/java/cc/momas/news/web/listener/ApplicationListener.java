package cc.momas.news.web.listener;

import cc.momas.news.common.DataSource;
import cc.momas.news.common.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * 数据源池, 当系统(application)启动的时候负责初始化数据库连接
 *
 * @author sothereer@gmail.com
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    /**
     * 全局配置
     */
    private static Properties APP_CONFIG = new Properties();

    private static final Logger log = LoggerFactory.getLogger(ApplicationListener.class);
    private static final String CONFIG_FILE_NAME = "application.properties";

    /**
     * 当容器初始化的时候去初始化系统各组件, 如果初始化失败则退出容器
     *
     * @param sce servlet上下文
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // jdk7 特性, 自动关闭资源
        try (InputStream configStream = ResourceUtil.getClasspathFile(CONFIG_FILE_NAME)) {

            Objects.requireNonNull(configStream, "config file [" + CONFIG_FILE_NAME + "] is not exist!");

            APP_CONFIG.load(configStream);
            initApplication();
        } catch (IOException ioe) {
            log.error("配置文件载入失败, application init failed: ", ioe);
            System.exit(2);
        } catch (Throwable t) {
            log.error("application init failed", t);
            System.exit(-1);
        }
    }

    /**
     * 初始化整个程序
     */
    private void initApplication() {
        // 初始化数据库
        DataSource.init(APP_CONFIG);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do
    }
}
