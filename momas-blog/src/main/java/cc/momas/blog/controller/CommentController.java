package cc.momas.blog.controller;

import cc.momas.blog.dto.DetailedBlog;
import cc.momas.blog.pojo.Comment;
import cc.momas.blog.pojo.User;
import cc.momas.blog.service.BlogService;
import cc.momas.blog.service.CommentService;
import cc.momas.blog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private LogService logService;
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", blogService.getDetailedBlog(blogId));
        return "blog";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlogId();
        //set Blog
        final DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        comment.setBlog(detailedBlog);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);

        logService.addLog("添加评论/回复", user == null ? "匿名用户" : user.getNickname() + " 评论 " + detailedBlog.getTitle());

        return "redirect:/comments/" + blogId;
    }
}
