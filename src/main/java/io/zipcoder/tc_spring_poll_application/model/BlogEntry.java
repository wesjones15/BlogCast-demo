package io.zipcoder.tc_spring_poll_application.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "blog_entry")
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BLOG_ENTRY_ID")
    private Long id;

    @NotEmpty
    @Column(name = "BLOG_ENTRY_TITLE")
    private String title;

    @NotEmpty
    @Column(name = "BLOG_ENTRY_BODY")
    private String body;

    @OneToMany
    @JoinColumn(name = "BLOG_ENTRY_ID")
    private Set<Comment> comments;

    @JoinColumn(name = "BLOG_ID")
    private Long blog_id;

    @JoinColumn(name = "USER_ID")
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
