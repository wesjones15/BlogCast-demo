package io.zipcoder.tc_spring_poll_application.service;

import io.zipcoder.tc_spring_poll_application.model.BlogEntry;
import io.zipcoder.tc_spring_poll_application.repositories.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogEntryService {
    @Autowired
    private BlogEntryRepository blogEntryRepository;

    public Iterable<BlogEntry> findAll() {
        return blogEntryRepository.findAll();
    }

    public BlogEntry findById(Long id) {
        return blogEntryRepository.findOne(id);
    }

    public BlogEntry addToBlog(Long blogId, BlogEntry blogEntry) {
        blogEntry.setBlog_id(blogId);
        return blogEntryRepository.save(blogEntry);
    }

    public Iterable<BlogEntry> findAllForBlog(Long blogId) {
        return blogEntryRepository.findBlogEntriesByBlog(blogId);
    }

    public BlogEntry update(Long id, BlogEntry blogEntry) {
        BlogEntry original = findById(id);
        original.setTitle(blogEntry.getTitle());
        original.setBody(blogEntry.getBody());
        return blogEntryRepository.save(original);
    }

    public Boolean delete(Long id) {
        blogEntryRepository.delete(id);
        return true;
    }
}


//TODO use userService and blogEntryService
// in BlogEntryController to assign user as blog owner
// or blog entry author