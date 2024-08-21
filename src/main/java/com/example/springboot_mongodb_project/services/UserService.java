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

    //Exibir por ID
    public User findById(String id){
        User user = repo.findById(id).get();
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    //Exibir por nome
    public User findByName(String name){
        User user = repo.findByName(name).get();
        return user;
    }

    //Adicionar usuario
    public User insert(User obj){
        return repo.insert(obj);
    }

    //Editar Usuario
    public User update(User obj){
        User newObj = repo.findById(obj.getId()).get();
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    //Deletar Usuario
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    //Usuario formatado pelo DTO
    public User fromDto(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }



}
