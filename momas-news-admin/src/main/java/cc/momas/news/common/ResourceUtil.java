package cc.momas.news.common;

import java.io.InputStream;

/**
 * 获取资源的工具
 *
 * @author Sod-Momas
 */
public abstract class ResourceUtil {

    /**
     * 获取classpath路径下的文件
     *
     * @param filename 文件名
     * @return 获取到的文件, 如果不存在则返回 null
     */
    public static InputStream getClasspathFile(String filename) {
        return ResourceUtil.class.getClassLoader().getResourceAsStream(filename);
    }
}
