package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.MemcardsMapper;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.MemcardsExample;
import cc.momas.customer.pojo.MemcardsExample.Criteria;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.IMemcardsService;

@Service
public class MemcardsServiceImpl implements IMemcardsService{

	@Autowired
	private MemcardsMapper memmapper;
	
	@Override
	public Pager<Memcards, MemcardsExample> queryByPager(Pager<Memcards, MemcardsExample> pager) {
		MemcardsExample example = new MemcardsExample();
		Criteria c = example.createCriteria();
		Memcards e = pager.getEntity();
		if(e != null) {
			if(e.getMemcardsCardid() != null && ! "".equals(String.valueOf(e.getMemcardsId()))) {
				c.andMemcardsCardidEqualTo(e.getMemcardsId().toString());
			}
			if(e.getMemcardsName() != null && ! "".equals(e.getMemcardsName())) {
				c.andMemcardsNameLike("%" + e.getMemcardsName() + "%");
			}
			if(e.getMemcardsMobile() != null && ! "".equals(e.getMemcardsMobile())) {
				c.andMemcardsMobileLike("%" + e.getMemcardsMobile() + "%");
			}
			if(e.getCardlevelsId() != null && ! "".equals(String.valueOf(e.getCardlevelsId()))) {
				c.andMemcardsCardidEqualTo(e.getCardlevelsId().toString());
			}
			if(e.getMemcardsState() != null && ! "".equals(String.valueOf(e.getMemcardsState()))) {
				c.andMemcardsCardidEqualTo(e.getMemcardsState().toString());
			}
		}
		pager.setEntityExample(example);
		int totalRecord = memmapper.countByExample(example);
		pager.setTotalRecordCount(totalRecord);
		List<Memcards> list = memmapper.queryByPager(pager);
		pager.setList(list);
		return pager;
	}

	/**
	 * 还没有实际使用过,实际作用需要做测试
	 */
	@Override
	public List<Memcards> queryByCardIdOrMobile(Memcards card) {
		MemcardsExample example = new MemcardsExample();
		//这里会产生两个example内部的内部类criteria,两个criteria才会是or关系
		example.or().andMemcardsCardidEqualTo(card.getMemcardsCardid());
		example.or().andMemcardsMobileEqualTo(card.getMemcardsMobile());
		return memmapper.selectByExample(example);
	}
	
	@Override
	public int addMemberCard(Memcards card) {
		return memmapper.insert(card);
	}

	@Override
	public int deleteById(int id) {
		return memmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Memcards queryById(int memcardsId) {
		return memmapper.selectByPrimaryKey(memcardsId);
	}

	@Override
	public int updateMemberCard(Memcards card) {
		return memmapper.updateByPrimaryKeySelective(card);
	}

	@Override
	public Memcards queryByCardId(String memcardsCardid) {
		MemcardsExample example = new MemcardsExample();
		Criteria c = example.createCriteria();
		c.andMemcardsCardidEqualTo(memcardsCardid);
		List<Memcards> members = memmapper.selectByExample(example);
		return members.size() < 1 ? null : members.get(0);
	}

	@Override
	public List<Memcards> queryAll() {
		return memmapper.selectByExample(new MemcardsExample());
	}

	@Override
	public Memcards queryByMobile(String mobile) {
		MemcardsExample example = new MemcardsExample();
		Criteria c = example.createCriteria();
		c.andMemcardsMobileLike("%" + mobile + "%");
		List<Memcards> members = memmapper.selectByExample(example);
		return members.size() < 1 ? null : members.get(0);
	}

	@Override
	public int importExcel(List<Memcards> memberCardList) {
		int count = 0;
		for(Memcards m : memberCardList) {
			count += memmapper.insert(m);
		}
		return count;
	}

	@Override
	public Memcards queryByCardIdOrMobile(String id) {
		MemcardsExample example = new MemcardsExample();
		example.or().andMemcardsCardidEqualTo(id);
		example.or().andMemcardsMobileEqualTo(id);
		List<Memcards> list = memmapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
    
}