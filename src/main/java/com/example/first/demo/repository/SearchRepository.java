package com.example.first.demo.repository;

import java.util.List;

import com.example.first.demo.model.User;


public interface SearchRepository{
  
  List<User> findtext(String text);
}
