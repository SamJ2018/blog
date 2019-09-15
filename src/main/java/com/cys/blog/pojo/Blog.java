package com.cys.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:09 PM
 **/
@Data
@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation; //赞赏是否开启
    private boolean shareStatement;
    private boolean isComment; //评论是否开启
    private boolean published; //是否发布
    private boolean recommend; //是否推荐

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST}) //级联新增，如果在blog新增一个tag，也会在在tag中插入
    private List<Tag> tags = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();
}
