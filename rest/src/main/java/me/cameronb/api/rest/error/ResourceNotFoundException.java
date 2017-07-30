package me.cameronb.api.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cameron on 7/30/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundException extends RuntimeException {

    private String resourceId;

    public ResourceNotFoundException(String resource, String message) {
        super(message);
        this.resourceId = resource;
    }

    public String getString() {
        return "{\"error\": \"" + this.getMessage() + "\"}";
    }
}
