package com.example.springboot_mongodb_project.resourcers;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.dto.UserDto;
import com.example.springboot_mongodb_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResourcers {

    @Autowired
    private UserService service;
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){

        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
