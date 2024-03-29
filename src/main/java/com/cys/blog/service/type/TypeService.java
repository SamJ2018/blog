package com.cys.blog.service.type;

import com.cys.blog.pojo.Type;
import com.cys.blog.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-7:37 PM
 **/
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable, User user);

    List<Type> listType();

    Type getTypeByName(String name);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

    List<Type> listTypeTop(Integer size);
}
