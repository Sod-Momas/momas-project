package cc.momas.housetenacy.service.impl;

import java.util.List;

import cc.momas.housetenacy.dao.IDistrictDAO;
import cc.momas.housetenacy.entity.District;
import cc.momas.housetenacy.service.IDistrictService;
import cc.momas.housetenacy.utils.BeanFactory;

public class DistrictServiceImpl implements IDistrictService {

	private IDistrictDAO districtDao = (IDistrictDAO) BeanFactory
			.getBean("districtDao");

	public List<District> queryAll() {
		return districtDao.queryAll();
	}

	public District queryById(Integer id) {
		return districtDao.queryById(id);
	}

}
