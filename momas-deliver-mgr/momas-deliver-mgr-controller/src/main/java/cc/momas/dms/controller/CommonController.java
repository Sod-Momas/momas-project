package cc.momas.dms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CommonController {
	
	@RequestMapping(value = "index/{dir}/{path}")
	private ModelAndView toPage(@PathVariable("dir") String dir, @PathVariable("path") String path) {
		StringBuilder sb = new StringBuilder();
		sb.append(dir).append('/').append(path);
		return new ModelAndView(sb.toString());
	}
	
	@RequestMapping(value="index/common/index",method=RequestMethod.GET)
	private ModelAndView toindex(HttpSession session) {
		if(session.getAttribute("LOGIN_USER") == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("common/index");
	}
//
//	@RequestMapping("common/validatecode")
//	private ModelAndView getValidateCode() {
//
//		
//	}

}
