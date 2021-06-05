package cc.momas.smbms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cc.momas.smbms.dao.BillMapper;
import cc.momas.smbms.entity.Bill;
import cc.momas.smbms.service.IBillService;
import cc.momas.smbms.util.MyBatisUtil;

@Service("BillService")
public class BillServiceImpl implements IBillService {

	/**
	 * 查询全部订单
	 */
	@Override
	public List<Bill> queryAll() {
		SqlSession session = new MyBatisUtil().getSession();  
		List<Bill> blist = session.getMapper(BillMapper.class).qeuryAll();
		session.commit();
		session.close();
		return blist;
	}

	@Override
	public int count() {
		return new MyBatisUtil().getSession(true).getMapper(BillMapper.class).count();
	}

	@Override
	public Bill queryById(Integer id) {
		return new MyBatisUtil().getSession(true).getMapper(BillMapper.class).queryById(id);
	}

	@Override
	public int add(Bill bill) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(BillMapper.class).add(bill);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(Bill bill) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(BillMapper.class).delete(bill);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(Bill bill) {
		SqlSession session = new MyBatisUtil().getSession();  
		int result = session.getMapper(BillMapper.class).update(bill);
		session.commit();
		session.close();
		return result;
	}

}
