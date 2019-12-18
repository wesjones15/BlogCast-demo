package io.zipcoder.tc_spring_poll_application.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_BODY")
    private String body;

//    @Column(name = "COMMENT_AUTHOR")
//    private User author;

//    private String authorName;

    @JoinColumn(name = "USER_ID")
    private Long authorId;

//    @ManyToOne

    @JoinColumn(name = "BLOG_ENTRY_ID")
    private Long blog_entry_id;

//    private Set<Reaction> reactions;
//    private Set<Tag> tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBlog_entry_id() {
        return blog_entry_id;
    }

    public void setBlog_entry_id(Long blog_entry_id) {
        this.blog_entry_id = blog_entry_id;
    }
//
//    public User getAuthor() {
//        return this.author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
}
