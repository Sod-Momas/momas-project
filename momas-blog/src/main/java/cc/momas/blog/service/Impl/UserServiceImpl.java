package cc.momas.blog.service.Impl;

import cc.momas.blog.dao.UserDao;
import cc.momas.blog.pojo.User;
import cc.momas.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.queryByUsernameAndPassword(username, DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
