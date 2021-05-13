package cc.momas.news.dao;

import cc.momas.news.NewsException;

public class DatabaseException extends NewsException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
