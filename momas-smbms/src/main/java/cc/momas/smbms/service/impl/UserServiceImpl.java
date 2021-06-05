package cc.momas.smbms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cc.momas.smbms.dao.UserMapper;
import cc.momas.smbms.entity.User;
import cc.momas.smbms.service.IUserService;
import cc.momas.smbms.util.MyBatisUtil;

@Service
public class UserServiceImpl implements IUserService {

	/** 登录
	 * @see cc.momas.smbms.service.impl.IUserService#login(cc.momas.smbms.entity.User)
	 */
	@Override
	public User login(User user) {
		
//		if (!("admin".equals(user.getUserName()) && "1234567".equals(user.getUserPassword()))) {
//			return null;
//		}
//		user.setUserid(20);
		return new MyBatisUtil().getSession(true).getMapper(UserMapper.class).queryByPassword(user);
	}

	@Override
	public List<User> queryAll() {
		return new MyBatisUtil().getSession(true).getMapper(UserMapper.class).queryAll();
	}
	
	@Override
	public int add(User user) {
		SqlSession session = new MyBatisUtil().getSession();
		int result = session.getMapper(UserMapper.class).add(user);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(User user) {
		SqlSession session = new MyBatisUtil().getSession();
		int result = session.getMapper(UserMapper.class).delete(user);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(User user) {
		SqlSession session = new MyBatisUtil().getSession();
		int result = session.getMapper(UserMapper.class).update(user);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public User queryById(Integer id) {
		SqlSession session = new MyBatisUtil().getSession();
		User user = session.getMapper(UserMapper.class).queryById(id);
		session.commit();
		session.close();
		return user;
	}
	
	
}
