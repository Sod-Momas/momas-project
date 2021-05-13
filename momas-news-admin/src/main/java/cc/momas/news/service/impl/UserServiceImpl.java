package cc.momas.news.service.impl;

import cc.momas.news.common.BeanFactory;
import cc.momas.news.dao.UserDao;
import cc.momas.news.entity.User;
import cc.momas.news.service.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = (UserDao) BeanFactory.getBean(BeanFactory.DAO_USER);

    @Override
    public User login(String username, String password) {
        // 参数验证
        if (StringUtils.isBlank(username)) {
            throw new AuthnException("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new AuthnException("密码不能为空");
        }
        password = DigestUtils.md5Hex(password);

        // 查询的 SQL 语句
        String sql = "SELECT `id`,`username`,`password`,`createtime`,`updatetime`,`is_admin`,`status` FROM `user` WHERE `username` = ? AND `password` = ? LIMIT 0,1";
        String[] params = {username, password};
        User user = userDao.login(sql, params);
        if (null == user) {
            throw new AuthnException("用户名或密码错误!");
        }
        return user;
    }

    @Override
    public List<User> listPage(int pageStart, int pageCount) {
        // 验证参数
        pageStart = pageStart < 0 ? 0 : pageStart; // 如果小于 0 则赋值为 0
        pageCount = (pageCount < 1 || 100 < pageCount) ? 20 : pageCount; // 如果超过正常范围则赋值为20

        // 查询的 SQL 语句
        String sql = "SELECT `id`,`username`,`password`,`createtime`,`updatetime`,`is_admin`,`status` FROM `user` LIMIT ?,?";
        String[] params = {String.valueOf(pageStart), String.valueOf(pageCount)};
        return userDao.list(sql, params);
    }

    @Override
    public void registe(String username, String password, boolean isAdmin, User oprator) {
        // 参数验证
        if (StringUtils.isBlank(username)) {
            throw new RegistrationExceptioin("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new RegistrationExceptioin("密码不能为空");
        }
        if (null == oprator || null == oprator.getId()) {
            throw new RegistrationExceptioin("操作者未知");
        }
        if (!oprator.getIsAdmin()) {
            // 非管理员操作
            throw new AuthzException("您没有权限,您配吗?");
        }

        password = DigestUtils.md5Hex(password);

        String sql = "INSERT INTO `user` "
                + "(`username`, `password`, `createtime`, `updatetime`, `is_admin`, `status`) "
                + "VALUES (?,?,NOW(),NOW(),?,0)";
        String[] params = {username, password, isAdmin ? "1" : "0"};
        userDao.insert(sql, params);
    }

    @Override
    public void update(Integer id, String username, String password, Boolean isAdmin, Byte status, User oprator) {

        // 参数验证
        if (null == id || id < 0) {
            throw new ObjectNotFoundException("修改用户未指定");
        }
        if (!(oprator.getId().equals(id) || oprator.getIsAdmin())) {
            // 不是自己操作也不是管理员操作
            throw new AuthzException("您没有权限,您配吗?");
        }
        if (StringUtils.isNoneBlank(password)) {
            password = DigestUtils.md5Hex(password);
        }

        List<String> params = new ArrayList<>(8); // 各参数
        String prefix = "UPDATE `user` SET ";
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isNoneBlank(username)) {
            sql.append("`username` = ?");
            params.add(username);
        }
        if (StringUtils.isNoneBlank(password)) {
            if (sql.length() > 0) {
                sql.append(",");
            }
            sql.append("`password` = ?");
            params.add(password);
        }
        if (null != isAdmin) {
            if (sql.length() > 0) {
                sql.append(",");
            }
            sql.append("`is_admin` = ?");
            params.add(isAdmin ? "1" : "0");
        }
        if (null != status) {
            if (sql.length() > 0) {
                sql.append(",");
            }
            sql.append("`status` = ? ");
            params.add(String.valueOf(status));
        }
        if (sql.length() > 0) {
            sql.append(",");
        }
        sql.append("`updatetime` = NOW()");

        sql.append(" WHERE `id` = ?");
        params.add(String.valueOf(id));

        sql = sql.insert(0, prefix);

        String[] arr = new String[params.size()];
        userDao.update(sql.toString(), params.toArray(arr));
    }

    @Override
    public void delete(Integer id, User oprator) {
        if (id == null || id < 0) {
            throw new ObjectNotFoundException("删除用户未指定");
        }
        if (!oprator.getIsAdmin()) {
            // 非管理员操作
            throw new AuthzException("您没有权限,您配吗?");
        }
        if (oprator.getId().equals(id)) {
            // 删除自身
            throw new AuthzException("不能删除自己!");
        }
        String sql = "DELETE FROM `user` WHERE id=?";
        userDao.delete(sql, id);
    }

}
