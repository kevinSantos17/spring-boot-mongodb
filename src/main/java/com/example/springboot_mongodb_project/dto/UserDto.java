package com.example.springboot_mongodb_project.dto;
import com.example.springboot_mongodb_project.domain.User;
import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    //Constructor Methods
    public UserDto() {}

    public UserDto(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    //Getters and Setters
    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
