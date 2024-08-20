package com.example.springboot_mongodb_project.services;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
