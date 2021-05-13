package cc.momas.news.service;

import cc.momas.news.NewsException;

/**
 * 身份认证异常时抛出该异常
 *
 * @author sod-momas
 */
public class AuthnException extends NewsException {
    public AuthnException(String message) {
        super(message);
    }
}
