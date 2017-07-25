package me.cameronb.api.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cameron on 7/24/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("Could not find user with username of \"" + username + "\".");
    }

}
