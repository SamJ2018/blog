package com.cys.blog.service.blog;

import com.cys.blog.pojo.Blog;
import com.cys.blog.pojo.User;
import com.cys.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-16-9:41
 **/
public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery, User user);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog getAndConvert(Long id);
}
