package cc.momas.news;

/**
 * 系统核心异常, 系统里发生的异常应该都继承自这个异常, 这样设计的原因是, 把项目与其他项目整合的时候, 每当有异常抛出,
 * 可以快速准确定位是哪个组件出了异常, 这也是自定义异常最大的优势所在
 *
 * @author Sod-Momas
 */
public class NewsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NewsException() {
        super();
    }

    public NewsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsException(String message) {
        super(message);
    }

    public NewsException(Throwable cause) {
        super(cause);
    }

    /**
     * 阻止调用链追踪,减少cpu消耗
     *
     * @return 导致异常的异常
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
