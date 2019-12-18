package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.model.BlogEntry;
import io.zipcoder.tc_spring_poll_application.repositories.BlogEntryRepository;
import io.zipcoder.tc_spring_poll_application.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class BlogEntryController {
    @Autowired
    BlogEntryService blogEntryService;


//    public PollController(PollRepository blogEntryRepository) {
//        this.blogEntryRepository = blogEntryRepository;
//    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/blogentry", method = RequestMethod.GET)
    public ResponseEntity<Iterable<BlogEntry>> getAllBlogEntries() {
        Iterable<BlogEntry> allBlogEntries = blogEntryService.findAll();
        return new ResponseEntity<>(allBlogEntries, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{blogId}/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<BlogEntry>> getAllEntriesForBlog(@PathVariable Long blogId) {
        Iterable<BlogEntry> blogEntries = blogEntryService.findAllForBlog(blogId);
        return new ResponseEntity<>(blogEntries, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{blogId}/entry", method = RequestMethod.POST)
    public ResponseEntity<BlogEntry> addBlogEntryToBlog(@PathVariable Long blogId, @RequestBody BlogEntry blogEntry) {
        //TODO verify user signed in, require author field filled with user
        blogEntry = blogEntryService.addToBlog(blogId, blogEntry);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{blogId}").buildAndExpand(blogEntry.getBlog_id()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/polls", method = RequestMethod.POST)
//    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
//        poll = blogEntryRepository.save(poll);
//        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poll.getId()).toUri();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(newPollUri);
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
//    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
//        Poll p = blogEntryRepository.findOne(pollId);
//        return new ResponseEntity<>(p, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updatePoll(@Valid @RequestBody Poll poll, @PathVariable Long pollId) {
//        Poll p = blogEntryRepository.save(poll);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
//        blogEntryRepository.delete(pollId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    public void verifyPoll(Long pollId) {
//        if (!blogEntryRepository.exists(pollId))
//            throw new ResourceNotFoundException();
//
//    }
}
