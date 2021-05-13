package cc.momas.news.service;

import cc.momas.news.NewsException;

/**
 * 对象找不到时抛该异常
 * @author Sod-Momas
 */
public class ObjectNotFoundException extends NewsException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
