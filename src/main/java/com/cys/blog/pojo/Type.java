package com.cys.blog.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:14 PM
 **/
@Data
@Entity
@Table(name = "t_type")
@ToString(exclude = "blogs")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
