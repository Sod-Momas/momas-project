package cc.momas.housetenacy.dao;

import cc.momas.housetenacy.entity.House;
import cc.momas.housetenacy.entity.Qb;
import cc.momas.housetenacy.utils.Pager;

public interface IHouseDAO {
	public Pager<House> queryAll(Pager<House> pager);

	public boolean addHouse(House house);

	public Pager<House> queryAllByTjPager(Pager<House> pager, Qb qb);
	
}
