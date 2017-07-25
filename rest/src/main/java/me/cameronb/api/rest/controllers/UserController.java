package me.cameronb.api.rest.controllers;

import me.cameronb.api.models.User;
import me.cameronb.api.models.UserRepository;
import me.cameronb.api.rest.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cameron on 7/24/2017.
 */
@RestController
@RequestMapping("/users/{username}")
public class UserController {

    private final UserRepository repository;

    @Autowired
    UserController(UserRepository repo) {
        this.repository = repo;
    }

    @RequestMapping(method = RequestMethod.GET)
    User getUser(@PathVariable String username) {
        User u = this.validateUser(username);
        return u;
    }

    private User validateUser(String username) {
        return this.repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

}
