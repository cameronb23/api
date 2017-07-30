package me.cameronb.api.rest.controllers;

import me.cameronb.api.models.User;
import me.cameronb.api.models.UserRepository;
import me.cameronb.api.rest.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cameron on 7/24/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    @Autowired
    UserController(UserRepository repo) {
        this.repository = repo;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable String id) {
        User u = this.validateUser(id);
        return u;
    }

    private User validateUser(String id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "User with specified ID not found."));
    }




    @RequestMapping(path = "/find/{username}", method = RequestMethod.GET)
    User findUser(@PathVariable String username) {
        return findByName(username);
    }

    private User findByName(String username) {
        return this.repository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username, "User with specified username not found."));
    }

}
