package cc.momas.car.dao;

import java.util.List;

import cc.momas.car.entity.Brand;

public interface IBrandDAO {

	public abstract void save(Brand transientInstance);

	public abstract void delete(Brand persistentInstance);

	public abstract Brand findById(java.lang.Integer id);

	public abstract List findByExample(Brand instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Brand merge(Brand detachedInstance);

	public abstract void attachDirty(Brand instance);

	public abstract void attachClean(Brand instance);

}