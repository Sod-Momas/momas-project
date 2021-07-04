package cc.momas.customer.service;

import cc.momas.customer.pojo.Exchanggifts;
import cc.momas.customer.pojo.ExchanggiftsExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.Pager;

public interface IExchanggiftsService {

	Pager<Exchanggifts, ExchanggiftsExample> queryByPager(Pager<Exchanggifts, ExchanggiftsExample> pager);

	int addGift(Exchanggifts gift);

	int deleteById(int id);

	int updateGift(Exchanggifts gift);

	Exchanggifts queryById(int id);
  
}