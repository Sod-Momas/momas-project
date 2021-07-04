package cc.momas.customer.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cc.momas.customer.pojo.Categories;
import cc.momas.customer.pojo.Pager;
import cc.momas.customer.pojo.Shops;
import cc.momas.customer.pojo.Users;
import cc.momas.customer.pojo.UsersExample;
import cc.momas.customer.service.ICategoriesService;
import cc.momas.customer.service.IShopsService;
import cc.momas.customer.service.IUsersService;

@Controller
@RequestMapping(value="/user")
public class UsersController {

	@Autowired
	private IUsersService userSvc;
	@Autowired
	private IShopsService shopSvc;
	@Autowired
	private ICategoriesService cateSvc;
	
	//删除用户,根据id
	@RequestMapping(value="deleteUser")
	@ResponseBody
	public String deleteUser(@RequestParam(value="usersId")int id) {
		int count = userSvc.delUserById(id);
		if(count > 0) {
			return "delete success";
		}else {
			return "delete failed";
		}
	}
	//新增用户
	@RequestMapping(value="addUser")
	public ModelAndView addUser(Users user) {
		user.setUsersPassword("123456");
		int count = userSvc.add(user);
		return new ModelAndView("redirect:/user/tomanage","msg",count > 0 ? "添加成功" : "添加失败");
	}
	
	//修改用户
	@RequestMapping(value="editUser")
	public String editUser(Users user) {
		userSvc.updateUser(user);
		return "redirect:/user/tomanage";
	}
	
	
	/**
	 * 这个方法用来给店铺添加管理员,实际操作是添加一个用户,并设置这个用户的关联商店为选中的商店
	 * 总觉得业务逻辑有问题
	 * 
	 * @param user 保存着将要添加的用户的用户名
	 * @param shop 选中的商店的,保存着商店id
	 * @return
	 */
	@RequestMapping(value="setAdmin")
	public String addUser(Users user,Shops shop) {
		user.setUsersPassword("123456");
		userSvc.add(user);
		shop.setShopIshassetadmin(Shops.HAVE_ADMIN);
		shopSvc.updateByPrimaryKeySelective(shop);
		return "redirect:/shop/manage";
	}
	
	//退出系统
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session) {
		if(null != session.getAttribute("LOGIN_USER")) {
			session.removeAttribute("LOGIN_USER");
		}
		return new ModelAndView("redirect:/");
	}
	
	//分页按条件查询用户
	@RequestMapping(value="query")
	@ResponseBody
	public Object index(Users user,@RequestParam(value="page") int page,@RequestParam("rows")int rows) {
		Pager<Users, UsersExample> pager = new Pager<Users,UsersExample>();
		pager.setPageNo(page < 1 ? 1 : page);
		pager.setPageSize(rows < 1 ? 1 : rows);
		pager.setEntity(user);
		pager =  userSvc.queryByPager(pager);		
		return  pager;
	}

	//修改密码
	@RequestMapping(value="repassword")
	public ModelAndView repassword(
			HttpSession session,
			@RequestParam(value="usersPassword") String oldPwd,
			@RequestParam(value="newPassword")  String newPwd) {
		//取出变量
		Users sessionUser = (Users) session.getAttribute("LOGIN_USER");
		ModelAndView mv = new ModelAndView();
		
		//验证
		if(!sessionUser.getUsersPassword().equals(oldPwd)) {
			return mv;//旧密码错误 
		}
		sessionUser.setUsersPassword(newPwd);
		
		userSvc.updateUser(sessionUser);
		mv.setViewName("redirect:/index");
		return mv;
	}
	
	//修改个人资料,少部分内容
	@RequestMapping(value="updatePersonProfile")
	public ModelAndView updateUserProfile(HttpSession session, Users user) {
		int count = userSvc.updateUser(user);
		if(count > 0) {
			user = userSvc.queryById(user.getUsersId());
			session.setAttribute("LOGIN_USER", user);
		}
		return new ModelAndView("redirect:/index");
	}
	
	
	/* ==========    TO      ========    */
	
	//去管理用户页面
	@RequestMapping(value="tomanage")
	public ModelAndView tomanage() {
		return new ModelAndView("user/manage");
	}
	//去修改密码页面
	@RequestMapping(value="toRepasswrod")
	public ModelAndView toRepassword(HttpSession session) {
		Users user = (Users) session.getAttribute("LOGIN_USER");
		if(user == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("user/repassword","user",user);
	}
	//去修改个人资料页面
	@RequestMapping(value="personProfile")
	public ModelAndView viewProfile(HttpSession session) {
		return new ModelAndView("user/personProfile");
	}
	
	//去添加用户
	@RequestMapping(value="toAdd")
	public ModelAndView toAddUser() {
		List<Categories> roles = cateSvc.queryAllUserRole();
		return new ModelAndView("user/add","roles",roles);
	}
	//去修改用户,根据id
	@RequestMapping(value="toEdit")
	public ModelAndView toEdit(@RequestParam(value="usersId")int id) {
		Users user = userSvc.queryById(id);
		List<Categories> roles = cateSvc.queryAllUserRole();
		ModelAndView mv = new ModelAndView("user/edit");
		mv.addObject("user",user);
		mv.addObject("roles",roles);
		return mv;
	}
}
