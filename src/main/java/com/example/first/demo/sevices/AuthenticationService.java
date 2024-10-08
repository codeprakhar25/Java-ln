package com.example.first.demo.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.first.demo.dtos.LoginUserDto;
import com.example.first.demo.dtos.RegisterUserDto;
import com.example.first.demo.model.User;
import com.example.first.demo.repository.UserRepositoryNorm;

public class AuthenticationService {

    @Autowired
   private UserRepositoryNorm userRepository;
    
   @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    // public AuthenticationService(
    //     UserRepository userRepository,
    //     AuthenticationManager authenticationManager,
    //     PasswordEncoder passwordEncoder
    // ) {
    //     this.authenticationManager = authenticationManager;
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    public User signup(RegisterUserDto input) {
        User user = new User();
                user.setFullName(input.getFullName());
                user.setEmail(input.getEmail());
                user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
