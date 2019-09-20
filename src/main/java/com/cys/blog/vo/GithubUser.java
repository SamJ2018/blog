package com.cys.blog.vo;

import lombok.Data;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-20-7:33
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
