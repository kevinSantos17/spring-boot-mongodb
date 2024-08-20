package com.example.springboot_mongodb_project.resourcers;

import com.example.springboot_mongodb_project.domain.User;
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
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria", "maria@mail.com");
        User jose = new User("2", "jose", "jose@mail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, jose));
        return ResponseEntity.ok().body(list);
    }
}
