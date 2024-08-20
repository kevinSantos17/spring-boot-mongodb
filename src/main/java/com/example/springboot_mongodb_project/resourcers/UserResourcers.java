package com.example.springboot_mongodb_project.resourcers;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResourcers {

    @Autowired
    private UserService service;
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){

        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
