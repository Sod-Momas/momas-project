package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.UsersMapper;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Users;
import cc.momas.customer.pojo.UsersExample;
import cc.momas.customer.pojo.UsersExample.Criteria;
import cc.momas.customer.service.IUsersService;

@Service
public class UsersServiceImpl  implements IUsersService{

	@Autowired
	private UsersMapper usermapper;
	
	@Override
	public Users findLogin(Users user) {
		UsersExample example = new UsersExample();
		example.createCriteria()
			.andUsersLoginnameEqualTo(user.getUsersLoginname())
			.andUsersPasswordEqualTo(user.getUsersPassword());
		List<Users> list = usermapper.selectByExample(example);
		if(list == null || list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public Integer add(Users user) {
		return usermapper.insert(user);
	}

	@Override
	public Pager<Users, UsersExample> queryByPager(Pager<Users, UsersExample> pager) {
		UsersExample ue = new UsersExample();
		Criteria c = ue.createCriteria();
		if(pager.getEntity() != null) {
			if(pager.getEntity().getUsersLoginname() != null && ! "".equals(pager.getEntity().getUsersLoginname())) {
				c.andUsersLoginnameLike("%"+ pager.getEntity().getUsersLoginname() +"%");
			}
			if(pager.getEntity().getUsersRealname() != null && ! "".equals(pager.getEntity().getUsersRealname())) {
				c.andUsersRealnameLike("%" + pager.getEntity().getUsersRealname() + "%");
			}
			if(pager.getEntity().getUsersTelephone() != null && ! "".equals(pager.getEntity().getUsersTelephone())) {
				c.andUsersTelephoneLike("%"+ pager.getEntity().getUsersTelephone()  + "%");
			}
		}
		pager.setEntityExample(ue);
		int totalRecord = usermapper.countByExample(ue);
		pager.setTotalRecordCount(totalRecord);
		List<Users> list = usermapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}

	@Override
	public int updateUser(Users user) {
		if(user.getUsersId() == null) {
			return 0;
		}
		return usermapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Users queryById(Integer usersId) {
		return usermapper.selectByPrimaryKey(usersId);
	}

	@Override
	public int delUserById(int id) {
		return usermapper.deleteByPrimaryKey(id);
	}	
   
}