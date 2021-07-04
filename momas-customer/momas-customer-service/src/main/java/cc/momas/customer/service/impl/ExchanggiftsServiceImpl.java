package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.ExchanggiftsMapper;
import cc.momas.customer.pojo.Exchanggifts;
import cc.momas.customer.pojo.ExchanggiftsExample;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IExchanggiftsService;

@Service
public class ExchanggiftsServiceImpl implements IExchanggiftsService{

	@Autowired
	private ExchanggiftsMapper giftmapper;
	
	@Override
	public Pager<Exchanggifts, ExchanggiftsExample> queryByPager(Pager<Exchanggifts, ExchanggiftsExample> pager) {
		ExchanggiftsExample example = new ExchanggiftsExample();
		pager.setEntityExample(example);
		int totalRecord = giftmapper.countByExample(example);
		pager.setTotalRecordCount(totalRecord);
		List<Exchanggifts> list = giftmapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}

	@Override
	public int addGift(Exchanggifts gift) {
		return giftmapper.insert(gift);
	}

	@Override
	public int deleteById(int id) {
		return giftmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateGift(Exchanggifts gift) {
		return giftmapper.updateByPrimaryKeySelective(gift);
	}

	@Override
	public Exchanggifts queryById(int id) {
		return giftmapper.selectByPrimaryKey(id);
	}
    
}