package cc.momas.dms.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.dms.pojo.BcStaff;
import cc.momas.dms.pojo.BcStaffExample;
import cc.momas.dms.service.IStaffService;
import cc.momas.util.Pager;

@RequestMapping("/staff")
@Controller
public class StaffController {

	@Autowired
	private IStaffService staffSvc;
	
	//下拉列表的模糊查询
	@RequestMapping("listajax")
	@ResponseBody
	private Object queryStaffWhitoutSubarea(@RequestParam(value="q",defaultValue="")String tj) {
		List<BcStaff> list = null;
		if(StringUtils.isNotBlank(tj)) {
			list = staffSvc.findListByTj(tj);//根据条件查询
		}else {
			list= staffSvc.findAll();
		}
		return list;
	}
	
	
	@RequestMapping(value="update")
	//修改 staff
	private String updteStaff(BcStaff staff) {
		staffSvc.updateById(staff);
		return "redirect:/index/base/staff";
	}
	
	//查询staff
	@RequestMapping(value="queryByPager")
	@ResponseBody
	private Object queryByPager(Pager<BcStaff, BcStaffExample> pager,int page,int rows) {
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager = staffSvc.queryByPager(pager);
		return pager;
	}
	
	//添加 staff
	@RequestMapping(value="add")
	private String addStaff(BcStaff staff) {
		staff.setDeltag("0");//设置"删除状态"
		staffSvc.save(staff);
		return "redirect:/index/base/staff";
	}
	
	//删除staff
	@RequestMapping(value="delete/{ids}")
	private String deleteBatch(@PathVariable("ids")String ids) {
		if(ids != null && 0 < ids.length()) {
			staffSvc.deleteBatch(ids);
		}
		return "redirect:/index/base/staff";
	}
	
	//还原staff
	@RequestMapping(value="restore/{ids}")
	private String restoreBatch(@PathVariable("ids")String ids) {
		staffSvc.restoreBatch(ids);
		return "redirect:/index/base/staff";
	}
}
