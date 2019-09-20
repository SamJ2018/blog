package com.cys.blog.controller;

import com.cys.blog.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-10:26
 **/
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model , @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)  Pageable pageable) {
        model.addAttribute("archiveMap", blogService.archiveBlog(pageable));
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
