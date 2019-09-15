package com.cys.blog.dao;

import com.cys.blog.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-7:40 PM
 **/
public interface TypeRepository extends JpaRepository<Type, Long> {
}
