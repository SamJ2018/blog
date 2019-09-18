package com.cys.blog.dao;

import com.cys.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-6:01 PM
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
