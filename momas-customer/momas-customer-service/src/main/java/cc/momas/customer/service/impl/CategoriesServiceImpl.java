package cc.momas.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.momas.customer.mapper.CategoriesMapper;
import cc.momas.customer.pojo.Categories;
import cc.momas.customer.pojo.CategoriesExample;
import cc.momas.customer.service.ICategoriesService;

@Service
public class CategoriesServiceImpl implements ICategoriesService{

	@Autowired
	private CategoriesMapper catemapper;
	
	@Override
	public List<Categories> queryAllShopCate() {
		CategoriesExample example = new CategoriesExample();
		example.createCriteria().andCategoryNameEqualTo("SP_Category")
		.andCategoryPidIsNotNull();
		return catemapper.selectByExample(example);
	}

	@Override
	public List<Categories> queryAllUserRole() {
		CategoriesExample example = new CategoriesExample();
		example.createCriteria().andCategoryNameEqualTo("SR_UserCategory")
		.andCategoryPidIsNotNull();
		return catemapper.selectByExample(example);
	}

	@Override
	public List<Categories> queryAllCardState() {
		CategoriesExample example = new CategoriesExample();
		example.createCriteria().andCategoryNameEqualTo("CD_State")
		.andCategoryPidIsNotNull();
		return catemapper.selectByExample(example);
	}

	@Override
	public List<Categories> queryAllOrderType() {
		CategoriesExample example = new CategoriesExample();
		example.createCriteria().andCategoryNameEqualTo("CS_Category")
		.andCategoryPidIsNotNull();
		return catemapper.selectByExample(example);
	}
	
	
   
}