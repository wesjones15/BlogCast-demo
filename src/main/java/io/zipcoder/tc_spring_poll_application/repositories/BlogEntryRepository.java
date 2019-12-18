package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.model.BlogEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEntryRepository extends /*PagingAndSortingRepository<BlogEntry, Long> {//*/CrudRepository<BlogEntry, Long> {
    @Query(value = "SELECT blog_entry.* FROM blog_entry, blog WHERE blog_entry.BLOG_ID = ?1 AND blog_entry.BLOG_ID = blog.BLOG_ID", nativeQuery = true)
    Iterable<BlogEntry> findBlogEntriesByBlog(Long blogId);
}
