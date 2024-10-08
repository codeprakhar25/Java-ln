package com.example.first.demo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.demo.model.User;
import com.example.first.demo.repository.SearchRepository;
import com.example.first.demo.repository.UserRepositoryNorm;

@Service
public class UserService {

    @Autowired
    private UserRepositoryNorm repository;

    @Autowired
    private SearchRepository searchRepository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUser(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getUserbytext(String text) {
        return searchRepository.findtext(text);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
