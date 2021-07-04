package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.ConsumeordersMapper;
import cc.momas.customer.mapper.MemcardsMapper;
import cc.momas.customer.pojo.Consumeorders;
import cc.momas.customer.pojo.ConsumeordersExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.MemcardsExample;
import cc.momas.customer.pojo.ConsumeordersExample.Criteria;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IConsumeordersService;

@Service
public class ConsumeordersServiceImpl implements IConsumeordersService{

	@Autowired
	private ConsumeordersMapper ordermapper;
	@Autowired
	private MemcardsMapper membermapper;
	
	
	@Override
	public int add(Consumeorders order) {
		return ordermapper.insert(order);
	}
	
	public Pager<Consumeorders, ConsumeordersExample> queryByPager(Pager<Consumeorders, ConsumeordersExample> pager) {
		
		ConsumeordersExample example = new ConsumeordersExample();
		Criteria c = example.createCriteria();
		if(pager.getEntity() != null) {
			if(pager.getEntity().getMemcardsCardid() != null && !"".equals(pager.getEntity().getMemcardsCardid())) {
				c.andMemcardsCardidEqualTo(pager.getEntity().getMemcardsCardid());
			}
		}
		pager.setEntityExample(example);
		int totalRecord = ordermapper.countByExample(example);
		pager.setTotalRecordCount(totalRecord);
		List<Consumeorders> list = ordermapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}

	@Override
	public List<Consumeorders> queryAll() {
		return ordermapper.selectByExample(new ConsumeordersExample());
	}

	@Override
	public Pager<Consumeorders, ConsumeordersExample> queryOrderByMemberCardInPager(String identity, int rows, int pageNo) {
		Pager<Consumeorders, ConsumeordersExample> pager = new Pager<>();
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setPageNo(pageNo < 1 ? 1 : pageNo);
		
		if(identity == null || "".equals(identity)) {
			//当外面并没有传标识进来的时候
			//查询全部,并且带分页
			pager.setEntityExample(new ConsumeordersExample());
			pager.setTotalRecordCount(ordermapper.countByExample(new ConsumeordersExample()));
			pager.setList(ordermapper.selectByPager(pager));
			return pager;
		}
		
		MemcardsExample example = new MemcardsExample();
		example.or().andMemcardsCardidEqualTo(identity);
		example.or().andMemcardsMobileEqualTo(identity);
		List<Memcards> memberCardList = membermapper.selectByExample(example);
		if(memberCardList == null || memberCardList.size() < 1) {
			//没有查到该用户则不作后续查询
			return null;
		} 
		//查询会员-结束
		
		ConsumeordersExample example1 = new ConsumeordersExample();
		//输入查询条件,保存在Example里的Criteria中
		//example1.createCriteria().andMemcardsIdEqualTo(memberCardList.get(0).getMemcardsId());
		example1.createCriteria().andMemcardsCardidEqualTo(memberCardList.get(0).getMemcardsCardid());
		pager.setEntityExample(example1);
		int totalRecord = ordermapper.countByExample(example1);
		pager.setTotalRecordCount(totalRecord);
		pager.setEntityExample(example1);
		List<Consumeorders> list = ordermapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}

}