package cc.momas.customer.service;

import java.util.List;

import cc.momas.customer.pojo.Categories;

public interface ICategoriesService {
	List<Categories> queryAllShopCate();

	List<Categories> queryAllUserRole();

	List<Categories> queryAllCardState();

	List<Categories> queryAllOrderType();
}