package me.cameronb.api.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Cameron on 7/30/2017.
 */
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFound(ResourceNotFoundException e) {
        ErrorResponse r = new ErrorResponse();
        r.setErrorCode("Not Found");
        r.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }

}
