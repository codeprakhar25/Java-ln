package com.example.first.demo.dtos;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;



@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class RegisterUserDto {
  private String email;
  
  private String password;
  
  private String fullName;
  

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

}
