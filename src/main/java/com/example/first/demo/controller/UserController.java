package com.example.first.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.demo.model.User;
import com.example.first.demo.sevices.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
  
  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUser(){
    return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    };
  
    
}
