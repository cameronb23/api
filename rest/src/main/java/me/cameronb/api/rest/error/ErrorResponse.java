package me.cameronb.api.rest.error;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Cameron on 7/30/2017.
 */
public class ErrorResponse {

    @Getter @Setter private String errorCode;
    @Getter @Setter private String errorMessage;

}
