package cc.momas.news.service;

import cc.momas.news.NewsException;

/**
 * 权限检查/授权失败时抛此异常
 *
 * @author Sod-Momas
 */
public class AuthzException extends NewsException {

    public AuthzException(String message) {
        super(message);
    }
}
