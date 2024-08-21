package com.example.springboot_mongodb_project.services;

import com.example.springboot_mongodb_project.domain.User;
import com.example.springboot_mongodb_project.dto.UserDto;
import com.example.springboot_mongodb_project.repository.UserRepository;
import com.example.springboot_mongodb_project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    //Exibir todos os usuarios
    public List<User> findAll(){
        return repo.findAll();
    }

    //Exibir 1 usuario especifico
    public User findById(String id){
        User user = repo.findById(id).get();
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    //Adicionar usuario
    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User fromDto(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public User findByName(String name){
        User user = repo.findByName(name).get();
        return user;
    }

}
