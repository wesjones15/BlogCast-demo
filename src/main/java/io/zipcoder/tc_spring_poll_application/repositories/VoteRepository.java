//package io.zipcoder.tc_spring_poll_application.repositories;
//
//import io.zipcoder.tc_spring_poll_application.model.Vote;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {//CrudRepository<Vote, Long> {
//    @Query(value = "SELECT v.* FROM Option o, Vote v WHERE o.POLL_ID = ?1 AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
//    Iterable<Vote> findVotesByPoll(Long pollId);
//}
