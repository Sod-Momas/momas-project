package cc.momas.blog.service;

import cc.momas.blog.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

    /**
     * 查找所有评论
     */
    List<Comment> list(Boolean isCheck, int page, int limit);

    long count(Boolean isCheck);

    long deleteById(Long id);

    long accessById(Long id);
}
