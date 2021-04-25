package cc.momas.car.service.impl;

import java.util.List;

import cc.momas.car.dao.ICarmodalDAO;
import cc.momas.car.entity.Carmodal;
import cc.momas.car.service.ICarmodalService;

public class CarmodalServiceImpl implements ICarmodalService {
	private ICarmodalDAO cDao;

	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.CarmodalService#findAll()
	 */
	public List<Carmodal> findAll() {
		return cDao.findAll();
	}

	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.CarmodalService#setcDao(cc.momas.car.dao.ICarmodalDAO)
	 */
	public void setcDao(ICarmodalDAO cDao) {
		this.cDao = cDao;
	}

	public Carmodal findById(Integer id) {
		return cDao.findById(id);
	}

	public List<Carmodal> findByBrandId(Integer brandId) {
		return cDao.findByProperty("brand.brandid", brandId);
	}
}
