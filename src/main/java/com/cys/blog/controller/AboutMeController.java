package com.cys.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-10:35
 **/
@Controller
public class AboutMeController {
    @Controller
    public class AboutShowController {

        @GetMapping("/about")
        public String about() {
            return "about";
        }
    }

}
