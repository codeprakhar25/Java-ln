package com.example.first.demo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.first.demo.model.User;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;

@Component
public class SearchRepoImp  implements SearchRepository  {

  @Autowired
  private MongoConverter convertor;

  @Autowired
  MongoClient client;

  @Override
  public List<User> findtext(String text) {

      final List<User> users = new ArrayList<>();

      MongoDatabase database = client.getDatabase("Cluster0");
      MongoCollection<Document> collection = database.getCollection("users");
      AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
              new Document("text",
                              new Document("query", text)
                                      .append("path", Arrays.asList("name", "age")))),
              new Document("$sort",
                      new Document("age", 1L))));


      result.forEach(doc -> users.add(convertor.read(User.class, doc)));

      return users;
  }
  
}
