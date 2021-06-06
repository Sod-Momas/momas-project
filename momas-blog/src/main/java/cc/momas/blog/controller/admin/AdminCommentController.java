package cc.momas.blog.controller.admin;

import cc.momas.blog.pojo.Comment;
import cc.momas.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 评论管理
 */
@Controller
public class AdminCommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查找评论列表
     *
     * @param page    查找页数
     * @param limit   每页几条
     * @param isCheck 评论是否已审核通过，可空
     * @return 筛选后的评论列表
     */
    @GetMapping("/admin/comments")
    public String getComments(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "limit", defaultValue = "10") int limit,
                              @RequestParam(value = "isCheck", defaultValue = "false") Boolean isCheck,
                              Model model) {
        List<Comment> commentList = commentService.list(isCheck, page, limit);
        final long count = commentService.count(isCheck);
        model.addAttribute("commentList", commentList);
        model.addAttribute("count", count);
        return "admin/comments";
    }

    @RequestMapping("/admin/comment/delete")
    public String deleteComment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        long effect = commentService.deleteById(id);
        redirectAttributes.addAttribute("message", effect > 0 ? "删除成功" : "删除失败");
        return "redirect:/admin/comments";
    }

    @RequestMapping("/admin/comment/access")
    public String accessComment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        long effect = commentService.accessById(id);
        redirectAttributes.addAttribute("message", effect > 0 ? "审核成功" : "审核失败");
        return "redirect:/admin/comments";
    }
}
