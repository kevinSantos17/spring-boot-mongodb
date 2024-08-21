package com.example.springboot_mongodb_project.resourcers;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.dto.UserDto;
import com.example.springboot_mongodb_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResourcers {

    @Autowired
    private UserService service;

    //Exibir todos
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //Exibir por id
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id){

        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }

    //Inserir novo
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto){

        User obj = service.fromDto(objDto);
        obj = service.insert(obj);
        return ResponseEntity.accepted().build();
    }

    //Deletar
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> findByIdDelete(@PathVariable String id){

        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    //Exibir por nome
    @RequestMapping(value="/name", method= RequestMethod.GET)
    public ResponseEntity<UserDto> findByName(@RequestParam String name){

        User obj = service.findByName(name);
        return ResponseEntity.ok().body(new UserDto(obj));
    }
}
