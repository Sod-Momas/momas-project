package cc.momas.blog.controller;

import cc.momas.blog.dto.DetailedBlog;
import cc.momas.blog.dto.FirstPageBlog;
import cc.momas.blog.dto.RecommendBlog;
import cc.momas.blog.pojo.Comment;
import cc.momas.blog.pojo.Tag;
import cc.momas.blog.pojo.Type;
import cc.momas.blog.service.BlogService;
import cc.momas.blog.service.CommentService;
import cc.momas.blog.service.TagService;
import cc.momas.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        /*System.out.println("num:"+allFirstPageBlog.size());
        for (FirstPageBlog firstPageBlog : allFirstPageBlog) {
            System.out.println(firstPageBlog);
        }*/
        List<Type> allType = typeService.getAllType();
        /*System.out.println("num:" + allType.size());
        for (Type type : allType) {
            System.out.println(type);
        }*/
        List<Tag> allTag = tagService.getAllTag();
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 100);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        /*for (FirstPageBlog firstPageBlog : searchBlog) {
            System.out.println(firstPageBlog);
        }*/
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}
