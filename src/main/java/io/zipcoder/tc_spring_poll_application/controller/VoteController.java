//package io.zipcoder.tc_spring_poll_application.controller;
//
//import io.zipcoder.tc_spring_poll_application.model.Vote;
//import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//@RestController
//public class VoteController {
//    private VoteRepository voteRepository;
//
//    @Autowired
//    public VoteController(VoteRepository voteRepository) {
//        this.voteRepository = voteRepository;
//    }
//
//    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
//    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
//        vote = voteRepository.save(vote);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{pollId}").buildAndExpand(vote.getId()).toUri());
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/polls/votes", method = RequestMethod.GET)
//    public Iterable<Vote> getAllVotes() {
//        return voteRepository.findAll();
//    }
//
//    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
//    public Iterable<Vote> getVote(@PathVariable Long pollId) {
//        return voteRepository.findVotesByPoll(pollId);
//    }
//    //valid value required to post vote, but it gets vote data from id not value. and id changes depending on springs mood between reloads
//
//
//}
