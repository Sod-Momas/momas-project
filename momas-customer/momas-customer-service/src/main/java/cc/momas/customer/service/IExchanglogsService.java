package cc.momas.customer.service;

import cc.momas.customer.pojo.Exchanglogs;
import cc.momas.customer.pojo.ExchanglogsExample;
import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.Pager;

public interface IExchanglogsService {

	int addLog(Memcards card, String rows);

	Pager<Exchanglogs, ExchanglogsExample> queryOrderByMemberCardInPager(String identity, int rows, int pageNo);
    
}