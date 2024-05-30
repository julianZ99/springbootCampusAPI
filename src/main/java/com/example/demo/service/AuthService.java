package com.example.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.User;
import com.example.demo.models.view.LoginDTO;
import com.example.demo.models.view.RegistrationDTO;
import com.example.demo.repository.UserRepo;

@Service
public class AuthService {
    private final UserRepo userRepo;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthService(
        UserRepo userRepo,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegistrationDTO input) {
        User user = new User(
                            input.getFirstname(),
                            input.getLastname(),
                            input.getDni(),
                            passwordEncoder.encode(input.getPassword()),
                            input.getEmail());
        return userRepo.save(user);
    }

    public User authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepo.findByEmail(input.getEmail())
                .orElseThrow();
    }
}

