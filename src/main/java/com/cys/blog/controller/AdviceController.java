package com.cys.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-20-9:59
 **/
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String advice() {
        return "advice";
    }
}
