package com.cys.blog.vo;

import lombok.Data;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-16-10:42
 **/
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;
}
