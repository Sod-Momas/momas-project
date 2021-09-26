package cc.momas.dms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.momas.dms.pojo.AuthFunction;
import cc.momas.dms.pojo.AuthFunctionExample;
import cc.momas.dms.pojo.TUser;
import cc.momas.dms.service.IFunctionService;
import cc.momas.util.Pager;

@Controller
@RequestMapping("/function")
public class FunctionController {

	@Autowired
	private IFunctionService funSvc;
	
	@RequestMapping("add")
	private String add(AuthFunction function) {
		funSvc.save(function);
		return "system/authz";
	}
	
	//查找功能菜单
	@RequestMapping("findMenu")
	@ResponseBody
	private Object findMenu(HttpServletResponse response,HttpSession session) {
		TUser user = (TUser) session.getAttribute("LOGIN_USER");
		if(user == null) {
			return null;
		}
		List<AuthFunction> funs = funSvc.qeuryByUserId(user.getUserId());
		if(funs == null || funs.size() < 1) {
			response.setStatus(404);
			return "'msg':'没有获取到东西'";
		}
		return funs;
	}
	
	@RequestMapping("queryAllfunction")
	@ResponseBody
	private Object queryAllfunction() {
		return funSvc.queryAll();
	}
	
	//分页查询
	@RequestMapping("queryByPager")
	@ResponseBody
	private Object queryByPager() {
		Pager<AuthFunction, AuthFunctionExample> pager = new Pager<>();
//		pager.setPageSize(rows < 1 ? 1 : rows);
//		pager.setPageNo(page < 1 ? 1 : page);
//		pager = funSvc.queryByPager(pager);
		pager.setList(funSvc.queryAll());
		return pager;
		
	}
}
