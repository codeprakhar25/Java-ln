package com.example.first.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.first.demo.model.User;

public interface UserRepositoryNorm extends MongoRepository<User, String> {
  List<User> findByAge(int age);
  Optional<User> findByEmail(String email);
}
