package cc.momas.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.customer.pojo.Categories;
import cc.momas.customer.service.ICategoriesService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoriesService cateSvc;
	
	@RequestMapping("queryallcardstates")
	@ResponseBody
	public List<Categories> queryAllCardState(){
		List<Categories> list = cateSvc.queryAllCardState();
		return list;
	}
}
