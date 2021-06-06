package cc.momas.blog.service;

import cc.momas.blog.pojo.User;

public interface UserService {

    User checkUser(String username, String password);
}
