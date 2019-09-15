package com.cys.blog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-15-5:16 PM
 **/
@Entity
@Table(name="t_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments=new ArrayList<>();

    @ManyToOne
    private Comment parentComment;
}
