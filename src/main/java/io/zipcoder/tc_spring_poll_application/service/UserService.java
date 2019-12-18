package io.zipcoder.tc_spring_poll_application.service;

import io.zipcoder.tc_spring_poll_application.model.User;
import io.zipcoder.tc_spring_poll_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public User update(Long id, User user) {
        User original = userRepository.findOne(id);
        original.setUsername(user.getUsername());
        //update other things too
        return userRepository.save(original);
    }

    public Boolean delete(Long id) {
        userRepository.delete(id);
        return true;
    }
}
