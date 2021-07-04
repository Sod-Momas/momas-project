package cc.momas.customer.service;

import java.util.List;

import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Shops;
import cc.momas.customer.pojo.ShopsExample;

public interface IShopsService {

	
	List<Shops> queryAll();

	int insert(Shops shop);

	int deleleShopById(Shops shop);

	Shops queryById(Integer shopId);

	int update(Shops shop);

	int queryCount();

	Pager<Shops, ShopsExample> queryPager(Pager<Shops, ShopsExample> pager);

	int updateByPrimaryKeySelective(Shops shop);

}
