package cc.momas.customer.service;

import java.util.List;

import cc.momas.customer.pojo.Cardlevels;
import cc.momas.customer.pojo.CardlevelsExample;
import cc.momas.customer.pojo.Pager;

public interface ICardlevelsService {

	Pager<Cardlevels, CardlevelsExample> queryByPager(Pager<Cardlevels, CardlevelsExample> pager);

	Cardlevels queryById(int id);

	int addLevel(Cardlevels level);

	int deleteLevelById(int id);

	int updateLevel(Cardlevels level);

	List<Cardlevels> queryAll();
    
	
}