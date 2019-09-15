package com.cys.blog.service;

import com.cys.blog.dao.UserRepository;
import com.cys.blog.pojo.User;
import com.cys.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-6:00 PM
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
