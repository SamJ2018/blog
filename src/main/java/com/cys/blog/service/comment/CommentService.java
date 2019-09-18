package com.cys.blog.service.comment;

import com.cys.blog.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-17-17:07
 **/
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
