package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    @Query(value = "SELECT comment.* FROM comment, blog_entry WHERE blog_entry.BLOG_ENTRY_ID = ?1 AND comment.BLOG_ENTRY_ID = blog_entry.BLOG_ENTRY_ID", nativeQuery = true)
    Iterable<Comment> findCommentsByBlogEntry(Long blogEntryId);

}
