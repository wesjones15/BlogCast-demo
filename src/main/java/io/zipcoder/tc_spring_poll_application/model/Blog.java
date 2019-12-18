package io.zipcoder.tc_spring_poll_application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BLOG_ID")
    private Long id;

    @Column(name = "BLOG_TITLE")
    private String title;

    @Column(name = "BLOG_DESC")
    private String description;

    @OneToMany
    @JoinColumn(name = "BLOG_ID")
    private Set<User> owners;

    @OneToMany
    @JoinColumn(name = "BLOG_ID")
    private Set<BlogEntry> blogEntries;

    public Blog() {}
//    public Blog(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }

    public Set<BlogEntry> getBlogEntries() {
        return blogEntries;
    }

    public void setBlogEntries(Set<BlogEntry> blogEntries) {
        this.blogEntries = blogEntries;
    }
}
