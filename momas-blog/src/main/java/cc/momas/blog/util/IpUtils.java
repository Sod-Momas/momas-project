package cc.momas.blog.util;

public abstract class IpUtils {
    private static final ThreadLocal<String> currentIp = new ThreadLocal<>();

    public static String getIp() {
        return currentIp.get();
    }

    public static void setIp(String ip) {
        currentIp.set(ip);
    }
}
