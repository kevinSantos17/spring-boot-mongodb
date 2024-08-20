package com.example.springboot_mongodb_project.repository;

import com.example.springboot_mongodb_project.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
