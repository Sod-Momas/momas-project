package cc.momas.car.service.impl;

import java.util.List;

import cc.momas.car.dao.ICarinfoDAO;
import cc.momas.car.entity.Carinfo;
import cc.momas.car.service.ICarinfoService;
import cc.momas.car.util.QueryCondition;

public class CarinfoServiceImpl implements ICarinfoService {
	private ICarinfoDAO cDao; 
	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.ICarinfoService#findAll()
	 */
	public List<Carinfo> findAll(){
		return cDao.findAll();
	}

	/* (non-Javadoc)
	 * @see cc.momas.car.service.impl.ICarinfoService#setcDao(cc.momas.car.dao.ICarinfoDAO)
	 */
	public void setcDao(ICarinfoDAO cDao) {
		this.cDao = cDao;
	}

	public void save(Carinfo carinfo) {
		this.cDao.save(carinfo);		
	}

	public List<Carinfo> findByConditions(QueryCondition qc) {
		return this.cDao.findByCriteria(qc);
	}
}
