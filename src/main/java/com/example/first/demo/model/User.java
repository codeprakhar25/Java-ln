package com.example.first.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private int age;

    // getters and setters
    public String getId() {
        return id;
        }
        public void setId(String id) {
            this.id = id;
            }
    // Getters and setters
}  
