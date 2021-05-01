package cc.momas.housetenacy.service.impl;

import cc.momas.housetenacy.dao.IHouseDAO;
import cc.momas.housetenacy.entity.House;
import cc.momas.housetenacy.entity.Qb;
import cc.momas.housetenacy.service.IHouseService;
import cc.momas.housetenacy.utils.BeanFactory;
import cc.momas.housetenacy.utils.Pager;

public class HouseServiceImpl implements IHouseService {
	private IHouseDAO houseDao = (IHouseDAO) BeanFactory.getBean("houseDao");

	@Override
	public Pager<House> queryAllByPager(Pager<House> pager) {
		return houseDao.queryAll(pager);
	}

	@Override
	public boolean addHouse(House house) {
		return houseDao.addHouse(house);
	}

	@Override
	public Pager<House> queryAllByTjPager(Pager<House> pager, Qb qb) {
		return houseDao.queryAllByTjPager(pager, qb);
	}

}
