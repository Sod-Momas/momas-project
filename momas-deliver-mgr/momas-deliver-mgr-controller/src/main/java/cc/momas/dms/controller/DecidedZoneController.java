package cc.momas.dms.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.customer.ws.IShopWs;
import cc.momas.customer.ws.Shops;
import cc.momas.dms.pojo.BcDecidedzone;
import cc.momas.dms.pojo.BcDecidedzoneExample;
import cc.momas.dms.service.IDecidedZoneService;
import cc.momas.util.Pager;

@RequestMapping("/decidedzone")
@Controller
public class DecidedZoneController {

	@Autowired
	private IDecidedZoneService dzSvc;
	
	@Autowired
	private IShopWs shopWs;
	
	//远程调用cutstomer服务,获取未关联到定区的客户
	@RequestMapping("queryListNotAssociation")
	@ResponseBody
	public Object findListNotAssociation() {
		List<Shops> list = shopWs.queryAllShopsByNotAssociate();
		return list;
	}
	
	//远程调用customer服务,获取已经关联到指定的定区的客户
	@RequestMapping("queryListAssociation/{decidedzoneId}")
	@ResponseBody
	public Object findListHasAssociation(@PathVariable("decidedzoneId")int decidedzoneId) {
		List<Shops> list = shopWs.queryAllShopsByAssociate(decidedzoneId);
		return list;
	}
	
	//远程调用customer服务,将客户关联到定区
	@RequestMapping("assigncustomerstodecidedzone")
	public String assigncustomerstodeciedzone(@RequestParam(value="shops",required=false)String shops,
				@RequestParam("decidedzoneId")int decidedzoneId
			) {
		//shops 为店铺ID参数拼接字符串,如:1,2,4
		String [] sid = StringUtils.isNotBlank(shops)? shops.split(","):null;
		List<Integer> shopsId = new ArrayList<>();
		for(String id : sid) {
			shopsId.add(Integer.valueOf(id));
		}
		shopWs.updateShopsDecidezoneId(decidedzoneId, shopsId);
		return "base/decidedzone";
	}
	
	
	//更新
	@RequestMapping("update")
	private String update(BcDecidedzone dz,String [] subareaId) {
		if(dz != null && dz.getDecidedzoneId() != null) {
			dzSvc.update(dz,subareaId);
		}
		return "redirect:/index/base/decidedzone";
	}
	
	//批量删除
	@RequestMapping("delete/{ids}")
	private String deleteDecidedZone(@PathVariable("ids")String ids) {
		dzSvc.deleteBatch(ids);
		return "redirect:/index/base/decidedzone";
	}
	
	//添加
	@RequestMapping("add")
	private String addDecidedZone(BcDecidedzone decidedzone,String [] subareaId) {
		dzSvc.save(decidedzone,subareaId);
		return "redirect:/index/base/decidedzone";
	}
	
	//分页查询
	@RequestMapping("queryByPager")
	@ResponseBody
	private Object queryByPager(Pager<BcDecidedzone, BcDecidedzoneExample> pager,int page,int rows,BcDecidedzone dz) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(dz);
		return dzSvc.queryByPager(pager);
	}
}

