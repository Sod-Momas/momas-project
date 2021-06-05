package cc.momas.smbms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping("/main")
	public String main() {
		return "welcome";
	}

}
