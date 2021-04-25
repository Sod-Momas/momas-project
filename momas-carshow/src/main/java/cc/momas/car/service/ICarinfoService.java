package cc.momas.car.service;

import java.util.List;

import cc.momas.car.dao.ICarinfoDAO;
import cc.momas.car.entity.Carinfo;
import cc.momas.car.util.QueryCondition;

public interface ICarinfoService {

	public abstract List<Carinfo> findAll();

	public abstract void setcDao(ICarinfoDAO cDao);

	public abstract void save(Carinfo carinfo);

	public abstract List<Carinfo> findByConditions(QueryCondition qc);

}