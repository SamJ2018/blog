package com.cys.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:18 PM
 **/
@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs=new ArrayList<>();
}
