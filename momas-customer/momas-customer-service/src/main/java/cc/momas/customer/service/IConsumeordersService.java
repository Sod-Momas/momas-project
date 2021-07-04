package cc.momas.customer.service;

import java.util.List;

import cc.momas.customer.pojo.Consumeorders;
import cc.momas.customer.pojo.ConsumeordersExample;
import cc.momas.customer.pojo.Pager;

public interface IConsumeordersService {

	int add(Consumeorders order);

	List<Consumeorders> queryAll();

	Pager<Consumeorders, ConsumeordersExample> queryOrderByMemberCardInPager(String id, int rows, int pageNo);

}