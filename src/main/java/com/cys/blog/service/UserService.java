package com.cys.blog.service;

import com.cys.blog.pojo.User;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:59 PM
 **/
public interface UserService {
    User checkUser(String username, String password);
}
