package cc.momas.car.dao;

import java.util.List;

import cc.momas.car.entity.Carinfo;
import cc.momas.car.util.QueryCondition;

public interface ICarinfoDAO {

	public abstract void save(Carinfo transientInstance);

	public abstract void delete(Carinfo persistentInstance);

	public abstract Carinfo findById(java.lang.Integer id);

	public abstract List findByExample(Carinfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Carinfo merge(Carinfo detachedInstance);

	public abstract void attachDirty(Carinfo instance);

	public abstract void attachClean(Carinfo instance);
	
	public List findByCriteria(QueryCondition qc);

}