package com.cys.blog.vo;

import lombok.Data;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-20-7:35
 **/
@Data
public class AccessTokenVO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
