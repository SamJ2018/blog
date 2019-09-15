package com.cys.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-1:49 PM
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
