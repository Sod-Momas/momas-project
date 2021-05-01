package cc.momas.housetenacy.service;

import cc.momas.housetenacy.entity.House;
import cc.momas.housetenacy.entity.Qb;
import cc.momas.housetenacy.utils.Pager;

public interface IHouseService {
	public Pager<House> queryAllByPager(Pager<House> pager);

	public boolean addHouse(House house);

	public Pager<House> queryAllByTjPager(Pager<House> pager, Qb qb);
}
