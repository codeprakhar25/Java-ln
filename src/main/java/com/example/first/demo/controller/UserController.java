package com.example.first.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.demo.model.User;
import com.example.first.demo.sevices.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.demo.repository.SearchRepository;



@RestController
@RequestMapping("/api")
public class UserController {
  
  @Autowired
  private UserService userService;



  @GetMapping("/users")
  public ResponseEntity<List<User>> getUser(){
    return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    };
  
  
    @PostMapping("/user/")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
      try {
        User created= userService.saveUser(user);
        return new ResponseEntity<>(created,HttpStatus.CREATED); 
      } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }  

    @GetMapping("/users/{text}")
    public ResponseEntity<List<User>> getbyText(@PathVariable String text) {
      return new ResponseEntity<>(userService.getUserbytext(text),HttpStatus.OK);
    }
    
}
