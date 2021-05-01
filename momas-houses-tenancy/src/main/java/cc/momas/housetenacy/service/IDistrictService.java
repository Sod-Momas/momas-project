package cc.momas.housetenacy.service;

import java.util.List;

import cc.momas.housetenacy.entity.District;

public interface IDistrictService {
	public List<District> queryAll();
	
	public District queryById(Integer id);
}
