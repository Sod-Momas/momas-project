package cc.momas.car.service.impl;

import java.util.List;

import cc.momas.car.dao.IBrandDAO;
import cc.momas.car.entity.Brand;
import cc.momas.car.service.IBrandService;

public class BrandServiceImpl implements IBrandService {
	private IBrandDAO bDao;

	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.IBrandService#findAll()
	 */
	public List<Brand> findAll() {
		return bDao.findAll();
	}

	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.IBrandService#setbDao(cc.momas.car.dao.IBrandDAO)
	 */
	public void setbDao(IBrandDAO bDao) {
		this.bDao = bDao;
	}
}
