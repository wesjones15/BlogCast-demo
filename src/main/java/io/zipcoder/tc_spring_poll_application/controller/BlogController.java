package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.model.Blog;
import io.zipcoder.tc_spring_poll_application.repositories.BlogRepository;
import io.zipcoder.tc_spring_poll_application.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Blog>> findAllBlogs() {
        Iterable<Blog> allBlogs = blogService.findAll();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        blog = blogService.add(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable Long blogId) {
        Blog blog = blogService.findById(blogId);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //update

    //delete
}
