package com.cys.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-7:03 PM
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String list() {
        return "admin/blogs";
    }
}
