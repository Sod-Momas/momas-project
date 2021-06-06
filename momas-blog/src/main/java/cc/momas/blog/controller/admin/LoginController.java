package cc.momas.blog.controller.admin;

import cc.momas.blog.pojo.User;
import cc.momas.blog.service.LogService;
import cc.momas.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            //不要把密码传到前端页面
            user.setPassword(null);
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            attributes.addFlashAttribute("user", user);
            logService.addLog("登录", user.getNickname() + " 登录");
//            return "admin/index";
            return "redirect:/admin/blogs";
        } else {
            //因为这是redirect到index页面，如果用model会得不到这个数据
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        final Object object = session.getAttribute("user");
        if (object instanceof User) {
            logService.addLog("退出登录", ((User) object).getNickname() + " 退出登录");
        }
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
