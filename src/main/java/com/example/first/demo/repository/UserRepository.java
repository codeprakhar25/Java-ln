package com.example.first.demo.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.first.demo.model.User;

public interface UserRepository extends MongoRepository<User, String> {
  List<User> findByAge(int age);
}
