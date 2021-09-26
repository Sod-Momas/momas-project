package cc.momas.dms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.dms.pojo.AuthRole;
import cc.momas.dms.pojo.AuthRoleExample;
import cc.momas.dms.service.IAuthRoleService;
import cc.momas.util.Pager;

@RequestMapping("role")
@Controller
public class AuthRoleController {
	
	@Autowired
	private IAuthRoleService authRoleSvc;
	
	//添加一个角色
	@RequestMapping(value="add")
	private String add(AuthRole role, @RequestParam(value="authFuctionId",required=false)String authFuctionIds) {
		int count = 0;
		if(authFuctionIds != null && authFuctionIds.length() > 1) {
			String []ss = authFuctionIds.split(",");
			List<Integer> functionIds =new ArrayList<>();
			for (int i = 0; i < ss.length; i++) {
				functionIds.add(Integer.valueOf(ss[i]));
			}
			count = authRoleSvc.add(role,functionIds);
		}
		System.out.println("添加了"+count+"条记录");
		return "system/authz";
	}
	
	// 查询所有角色
	@RequestMapping("queryByPager")
	@ResponseBody
	private Object queryByPager(AuthRole role) {
		Pager<AuthRole, AuthRoleExample> pager = new Pager<>();
//		pager.setPageNo(page < 1 ? 1 : page);
//		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(role);
		return authRoleSvc.queryByPager(pager);
	}
	
	@RequestMapping("queryAll")
	@ResponseBody
	private List<AuthRole> queryAll(){
		return authRoleSvc.queryAll();
	}
}
