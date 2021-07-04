package cc.momas.customer.service;

import java.util.List;

import cc.momas.customer.pojo.Memcards;
import cc.momas.customer.pojo.MemcardsExample;
import cc.momas.customer.pojo.Pager;

public interface IMemcardsService {

	Pager<Memcards, MemcardsExample> queryByPager(Pager<Memcards, MemcardsExample> pager);

	int addMemberCard(Memcards card);

	int deleteById(int id);

	Memcards queryById(int memcardsId);

	int updateMemberCard(Memcards card);

	Memcards queryByCardId(String memcardsCardid);

	List<Memcards> queryAll();

	Memcards queryByMobile(String mobileNum);

	int importExcel(List<Memcards> memberCardList);

	Memcards queryByCardIdOrMobile(String id);
	
	List<Memcards> queryByCardIdOrMobile(Memcards card);
    
	
}