package cc.momas.car.service;

import java.util.List;

import cc.momas.car.dao.ICarmodalDAO;
import cc.momas.car.entity.Carmodal;

public interface ICarmodalService {

	public abstract List<Carmodal> findAll();

	public abstract void setcDao(ICarmodalDAO cDao);
	
	public abstract Carmodal findById(Integer id);

	public abstract List<Carmodal> findByBrandId(Integer brandId);
}