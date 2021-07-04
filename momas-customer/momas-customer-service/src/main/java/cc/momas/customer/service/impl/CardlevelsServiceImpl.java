package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.CardlevelsMapper;
import cc.momas.customer.pojo.Cardlevels;
import cc.momas.customer.pojo.CardlevelsExample;
import cc.momas.customer.pojo.CardlevelsExample.Criteria;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.service.ICardlevelsService;

@Service
public class CardlevelsServiceImpl implements ICardlevelsService{

	@Autowired
	private CardlevelsMapper lvmapper;
	
	@Override
	public Pager<Cardlevels, CardlevelsExample> queryByPager(Pager<Cardlevels, CardlevelsExample> pager) {
		CardlevelsExample example = new CardlevelsExample();
		Criteria c = example.createCriteria();
		if(pager.getEntity() != null) {
			if(pager.getEntity().getCardlevelsLevelname() != null && ! "".equals(pager.getEntity().getCardlevelsLevelname())) {
				c.andCardlevelsLevelnameLike("%" + pager.getEntity().getCardlevelsLevelname() + "%");
			}
		}
		pager.setEntityExample(example);
		int totalRecord = lvmapper.countByExample(example);
		pager.setTotalRecordCount(totalRecord);
		List<Cardlevels> list = lvmapper.selectByPager(pager);
		pager.setList(list);
		return pager;
		
	}

	@Override
	public Cardlevels queryById(int id) {
		return lvmapper.selectByPrimaryKey(id);
	}

	@Override
	public int addLevel(Cardlevels level) {
		return lvmapper.insert(level);
	}

	@Override
	public int deleteLevelById(int id) {
		return lvmapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateLevel(Cardlevels level) {
		return level.getCardlevelsId() ==null ? 0 : lvmapper.updateByPrimaryKeySelective(level);
	}

	@Override
	public List<Cardlevels> queryAll() {
		return lvmapper.selectByExample(new CardlevelsExample());
	}
 
}