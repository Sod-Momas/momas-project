package cc.momas.housetenacy.service.impl;

import java.util.List;

import cc.momas.housetenacy.dao.ITypesDAO;
import cc.momas.housetenacy.entity.Types;
import cc.momas.housetenacy.service.ITypesService;
import cc.momas.housetenacy.utils.BeanFactory;

public class TypesServiceImpl implements ITypesService {

	private ITypesDAO typesDao = (ITypesDAO) BeanFactory.getBean("typesDao");
	
	public List<Types> queryAll() {
		return typesDao.queryAll();
	}

}
