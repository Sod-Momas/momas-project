package cc.momas.car.service;

import java.util.List;

import cc.momas.car.dao.IBrandDAO;
import cc.momas.car.entity.Brand;

public interface IBrandService {

	public abstract List<Brand> findAll();

	public abstract void setbDao(IBrandDAO bDao);

}