package com.cys.blog.controller;

import com.cys.blog.exception.BlogNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-1:49 PM
 **/
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
