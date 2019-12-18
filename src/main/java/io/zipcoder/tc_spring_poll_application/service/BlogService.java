package io.zipcoder.tc_spring_poll_application.service;

import io.zipcoder.tc_spring_poll_application.model.Blog;
import io.zipcoder.tc_spring_poll_application.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    public Blog add(Blog blog) {
        // set owner to current user
        return blogRepository.save(blog);
    }

    public Blog update(Long id, Blog blog) {
        Blog original = blogRepository.findOne(id);
        original.setTitle(blog.getTitle());
        original.setDescription(blog.getDescription());
        original.setOwners(blog.getOwners());
        //use this method to assign multiple owners to blog
        return blogRepository.save(original);
    }

    public Boolean delete(Long id) {
        blogRepository.delete(id);
        return true;
    }

}
