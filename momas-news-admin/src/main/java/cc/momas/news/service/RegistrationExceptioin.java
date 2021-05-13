package cc.momas.news.service;

import cc.momas.news.NewsException;

/**
 * 注册时发生错误抛该异常
 *
 * @author Sod-Momas
 */
public class RegistrationExceptioin extends NewsException {
    public RegistrationExceptioin(String message) {
        super(message);
    }
}
