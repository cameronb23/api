package me.cameronb.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Cameron on 7/24/2017.
 */
@Document(collection = "users")
public class User {

    @Id
    @Getter private String id;


    @Getter private String email;

    @Getter private String username;

    @JsonIgnore
    @Getter private String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    User() {} // jpa only
}
