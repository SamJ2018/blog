package com.cys.blog.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:15 PM
 **/
@Entity
@Table(name="t_tag")
@Data
@ToString(exclude = "blogs")
public class Tag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs=new ArrayList<>();
}
