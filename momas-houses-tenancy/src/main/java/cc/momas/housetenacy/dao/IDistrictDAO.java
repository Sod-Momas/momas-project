package cc.momas.housetenacy.dao;

import java.util.List;

import cc.momas.housetenacy.entity.District;

public interface IDistrictDAO {

	public List<District> queryAll();
	
	public District queryById(Integer id);
	
}
