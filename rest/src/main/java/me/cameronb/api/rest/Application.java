package me.cameronb.api.rest;

import me.cameronb.api.models.User;
import me.cameronb.api.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("me.cameronb.api.models")
public class Application {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return (evt) -> userRepository.save(new User("admin@google.com", "admin", "test"));
    }
}