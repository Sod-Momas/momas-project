package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.ShopsMapper;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Shops;
import cc.momas.customer.pojo.ShopsExample;
import cc.momas.customer.pojo.ShopsExample.Criteria;
import cc.momas.customer.service.IShopsService;

@Service
public class ShopServiceImpl implements IShopsService{

	@Autowired
	private ShopsMapper mapper;
	
	@Override
	public List<Shops> queryAll() {
		return mapper.selectByExample(new ShopsExample());
	}

	@Override
	public int insert(Shops shop) {
		return mapper.insert(shop);
	}

	@Override
	public int deleleShopById(Shops shop) {
		return mapper.deleteByPrimaryKey(shop.getShopId());
	}

	@Override
	public Shops queryById(Integer shopId) {
		return mapper.selectByPrimaryKey(shopId);
	}

	@Override
	public int update(Shops shop) {
		return mapper.updateByPrimaryKeySelective(shop);
		
	}

	@Override
	public int queryCount() {
		return mapper.countByExample(null);
	}

	@Override
	public Pager<Shops, ShopsExample> queryPager(Pager<Shops, ShopsExample> pager) {
		
		ShopsExample example = new ShopsExample();
		Criteria c = example.createCriteria();
		if(pager.getEntity() != null) {
			if(pager.getEntity().getShopAddress() != null && ! "".equals(pager.getEntity().getShopAddress())) {
				c.andShopAddressLike("%" + pager.getEntity().getShopAddress() + "%");
			}
			if(pager.getEntity().getShopName() != null && ! "".equals(pager.getEntity().getShopName())) {
				c.andShopNameLike("%" + pager.getEntity().getShopName() + "%");
			}
			if(pager.getEntity().getShopContactname() != null && ! "".equals(pager.getEntity().getShopContactname())) {
				c.andShopContactnameLike("%" + pager.getEntity().getShopContactname() + "%");
			}
		}
		pager.setEntityExample(example);
		int totalRecord = mapper.countByExample(example);
		pager.setTotalRecordCount(totalRecord);
		List<Shops> list = mapper.selectByPager(pager);
		pager.setList(list);
		return pager;
	}

	@Override
	public int updateByPrimaryKeySelective(Shops shop) {
		return mapper.updateByPrimaryKeySelective(shop);
	}

}
