package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.User;
import com.example.demo.models.view.UserDTO;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
    }

    public UserDTO assignRole(Long userId, String role) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setRole(role);
        userRepo.save(user);
        return new UserDTO(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public UserDTO getBasicDataUserDTO(User savedUser) {
        UserDTO userDTO = new UserDTO(savedUser);
        return userDTO;
    }

}