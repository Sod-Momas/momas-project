package cc.momas.smbms.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cc.momas.smbms.dao.AddressMapper;
import cc.momas.smbms.dao.BillMapper;
import cc.momas.smbms.dao.ProviderMapper;
import cc.momas.smbms.dao.RoleMapper;
import cc.momas.smbms.dao.UserMapper;
import cc.momas.smbms.entity.Address;
import cc.momas.smbms.entity.Bill;
import cc.momas.smbms.entity.Provider;
import cc.momas.smbms.entity.Role;
import cc.momas.smbms.entity.User;
import cc.momas.smbms.util.MyBatisUtil;

public class Main {

	@Test
	public void test() {
		
		SqlSession session = new MyBatisUtil().getSession();  
			
//		System.err.println("====用户数量:>>>>" + session.getMapper(UserMapper.class).count());
//		System.err.println("====角色数量:>>>>" + session.getMapper(RoleMapper.class).count());
//		System.err.println("====供应商数量:>>>>" + session.getMapper(ProviderMapper.class).count());
//		System.err.println("====地址数量:>>>>" + session.getMapper(AddressMapper.class).count());
//		System.err.println("====订单数量:>>>>" + session.getMapper(BillMapper.class).count());
	
//		for (User user : session.getMapper(UserMapper.class).queryAll()) { System.out.println(user); }
//		for (Role role : session.getMapper(RoleMapper.class).queryAll()) { System.out.println(role); }
//		for (Provider provider :  session.getMapper(ProviderMapper.class).queryAll()) { System.out.println(provider); }
//		for (Address address : session.getMapper(AddressMapper.class).queryAll()) { System.out.println(address); }
//		for (Bill bill : session.getMapper(BillMapper.class).qeuryAll()) { System.out.println(bill); }
			
//		session.getMapper(UserMapper.class).add(new User(null,"sod2","sod2","sod2",0,new Date(),"13277937787","广东省揭阳市榕城区",3,2,new Date(),null,null));
//		session.getMapper(RoleMapper.class).add(new Role(4,"clark","clark",2,new Date(),null,null));
//		session.getMapper(ProviderMapper.class).add(new Provider(null,"pro-123","供应商名","描述","联系方式","13277884324","地址","020-1443",1,new Date(),null,null));
//		session.getMapper(AddressMapper.class).add(new Address(null, "联系方式", "描述", "515561", "010-1199284", 1, new Date(), null, null, 1));
//		session.getMapper(BillMapper.class).add(new Bill(null, "订单code", "name", "desc", "个", 23.3, 100.0, 0, 1, new Date(), null, null,2));
		
//		session.getMapper(UserMapper.class).update(new User(15,"sod1","sod2","sod3",1,new Date(),"13277937787","广东省揭阳市榕城区",3,2,new Date(),null,null));
//		session.getMapper(RoleMapper.class).update(new Role(2,"clark","clark",2,new Date(),null,null));
//		session.getMapper(ProviderMapper.class).update(new Provider(2,"pro-123","供应商名","描述",null,"13277884324","地址","020-1443",1,new Date(),null,null));
//		session.getMapper(AddressMapper.class).update(new Address(2, "联系方式", null, "515561", "010-1199284", 1, new Date(), null, null, 1));
//		session.getMapper(BillMapper.class).update(new Bill(2, "订单ccccccccccode", "name", null, "个", 23.3, 100.0, 0, 1, new Date(), null, null,2));
		
//		session.getMapper(UserMapper.class).delete(new User(18, null, null, null, null, null, null, null, null, null, null, null, null));
//		session.getMapper(RoleMapper.class).delete(new Role(4, null, null, null, null, null, null));
//		session.getMapper(ProviderMapper.class).delete(new Provider(17, null, null, null, null, null, null, null, null, null, null, null));
//		session.getMapper(BillMapper.class).delete(new Bill(19, null, null, null, null, null, null, null, null, null, null, null, null));
//		session.getMapper(AddressMapper.class).delete(new Address(8, null, null, null, null, null, null, null, null, null));
		
//		System.out.println(session.getMapper(BillMapper.class).queryById(1));
		
		session.commit();
		session.close();
		
//		System.out.println(new Address(null,"contact","地址描述","100113","13210010101",1,new Date(),null,null,3));
//		System.out.println(new Bill(null,"订单号","产品名","产品描述","产品单位",4.6D,3455.13D,0,2,new Date(),null,null,4));
//		System.out.println(new Provider(null,"code","name","desc","contact","address","13298242","fax",3,new Date(),null,null));
//		System.out.println(new Role(null,"code","name",4,new Date(),null,null));

	}
	
}
