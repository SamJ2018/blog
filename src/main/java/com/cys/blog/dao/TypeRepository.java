package com.cys.blog.dao;

import com.cys.blog.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-7:40 PM
 **/
public interface TypeRepository extends JpaRepository<Type, Long>, JpaSpecificationExecutor<Type> {
    Type findByName(String name);
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
