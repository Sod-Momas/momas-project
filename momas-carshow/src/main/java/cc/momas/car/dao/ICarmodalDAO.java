package cc.momas.car.dao;

import java.util.List;

import cc.momas.car.entity.Carmodal;

public interface ICarmodalDAO {

	public abstract void save(Carmodal transientInstance);

	public abstract void delete(Carmodal persistentInstance);

	public abstract Carmodal findById(java.lang.Integer id);

	public abstract List findByExample(Carmodal instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Carmodal merge(Carmodal detachedInstance);

	public abstract void attachDirty(Carmodal instance);

	public abstract void attachClean(Carmodal instance);

}