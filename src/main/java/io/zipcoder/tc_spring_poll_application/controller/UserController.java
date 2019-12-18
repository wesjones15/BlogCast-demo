package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.model.User;
import io.zipcoder.tc_spring_poll_application.repositories.UserRepository;
import io.zipcoder.tc_spring_poll_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> allUsers = userService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        user = userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //update
    //delete


    //TODO maybe tuck all endpoints behind user path to ensure user is permitted to access endpoints???
    // /users/{userId}/blogs --> return all blogs owned by user
    // /users/{userId}/blogs/{blogId} --> return blog if user is authorized, else return empty
    // /users/{userId}/blogs/{blogId}/entry --> show all blog entries by user in specified blog
    // /users/{userId}/blogs/{blogId}/entry/{blogEntryId} --> show blog entry of blog if user has access
    // /users/{userId}/activity --> return all blogs, blog entries, comments by user

}
