package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.model.Comment;
import io.zipcoder.tc_spring_poll_application.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentRepository.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{blogId}/entry/{blogEntryId}/comments", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Comment>> getAllCommentsForBlogEntryInBlog(@PathVariable Long blogId, @PathVariable Long blogEntryId) {
        Iterable<Comment> comments = commentRepository.findCommentsByBlogEntry(blogEntryId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{blogId}/entry/{blogEntryId}/comments", method = RequestMethod.POST)
    public ResponseEntity<Comment> postCommentOnBlogEntry(@PathVariable Long blogId, @PathVariable Long blogEntryId, @RequestBody Comment comment) {
        comment.setBlog_entry_id(blogEntryId);
        comment = commentRepository.save(comment);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{blogEntryId}").buildAndExpand(comment.getBlog_entry_id()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/blog/{blogId}/entry/{blogEntryId}/comments/{commentId}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getCommentById(@PathVariable Long blogId, @PathVariable Long blogEntryId, @PathVariable Long commentId) {
        Comment comment = commentRepository.findOne(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
