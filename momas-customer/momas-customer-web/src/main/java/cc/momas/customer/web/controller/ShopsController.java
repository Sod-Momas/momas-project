package cc.momas.customer.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Categories;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Shops;
import cc.momas.customer.pojo.ShopsExample;
import cc.momas.customer.service.ICategoriesService;
import cc.momas.customer.service.IShopsService;

@Controller
@RequestMapping(value = "/shop")
public class ShopsController {

	@Autowired
	private IShopsService shopSvc;
	@Autowired
	private ICategoriesService cateSvc;

	@RequestMapping(value = "queryAll")
	@ResponseBody
	public Object queryAll() {
		return shopSvc.queryAll();
	}

	@RequestMapping(value = "manage")
	public ModelAndView toManage() {
		return new ModelAndView("shop/shopmanage");
	}

	// 分页查询
	// page:"2" 第N页
	// rows:"10" 页面大小,一页10行
	@RequestMapping(value = "queryPage")
	@ResponseBody
	public Object queryByPager(@RequestParam("page") int pageNo, @RequestParam("rows") int rows, Shops shop) {
		Pager<Shops, ShopsExample> pager = new Pager<Shops, ShopsExample>();
		pager.setPageNo(pageNo < 1 ? 1 : pageNo);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(shop);
		pager = shopSvc.queryPager(pager);
		return pager;
	}

	// 添加店铺
	@RequestMapping(value = "addShop")
	public String addShop(Shops shop) {
		shop.setShopCreatetime(new Date());
		shopSvc.insert(shop);
		return "redirect:/shop/manage";
	}

	// 修改店铺
	@RequestMapping(value = "editShop")
	public String editShop(Shops shop) {
		shopSvc.update(shop);
		return "redirect:/shop/manage";
	}

	// 删除店铺
	@RequestMapping(value = "deleteShop")
	@ResponseBody
	public String deleteShop(Shops shop) {
		if (null == shop || shop.getShopId() == null) {
			return null;
		}
		int count = shopSvc.deleleShopById(shop);
		return count > 0 ? "delete success" : "delete falth";
	}

	// ======= TO ============

	// 去分配店铺管理员
	@RequestMapping(value = "toSetAdmin")
	public ModelAndView toSetAdmin(@RequestParam("shopId") Integer shopId) {
		return new ModelAndView("shop/setAdmin", "shopId", shopId);
	}

	// 去修改店铺的时候需要先获取所有店铺类型 和 获取当前店铺对象
	@RequestMapping(value = "toEdit")
	public ModelAndView toEdit(@RequestParam("shopId") Integer shopId) {
		List<Categories> catelist = cateSvc.queryAllShopCate();
		Shops shop = shopSvc.queryById(shopId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("shop/editShop");
		mv.addObject("categories", catelist);
		mv.addObject("shop", shop);
		return mv;
	}

	// 去添加店铺的时候需要先获取所有店铺类型
	@RequestMapping(value = "toAdd")
	public ModelAndView toAdd() {
		List<Categories> catelist = cateSvc.queryAllShopCate();
		return new ModelAndView("shop/addShop", "categories", catelist);
	}
}
