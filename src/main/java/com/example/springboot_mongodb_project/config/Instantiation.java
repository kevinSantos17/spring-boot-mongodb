package com.example.springboot_mongodb_project.config;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User kevin = new User(null, "Kevin Barbosa", "Kevin@mail.com");
        User talita = new User(null, "Talita Sousa", "Talita@mail.com");
        User cilene = new User(null, "Cilene Ferreira", "Cilene@mail.com");

        userRepository.save(kevin);
        userRepository.save(talita);
        userRepository.save(cilene);
    }
}
