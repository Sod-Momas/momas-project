package cc.momas.blog.controller.admin;

import cc.momas.blog.dto.PageResult;
import cc.momas.blog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/logs")
    public String logPage(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "10") int limit,
                          Model model) {
        final PageResult logPage = logService.getLogPage(page, limit);
        model.addAttribute("pageInfo", logPage);
        return "admin/logs";
    }

    @RequestMapping(value = "/log/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam("id") Integer id) {
        logService.deleteBatch(new Integer[]{id});
    }
}
