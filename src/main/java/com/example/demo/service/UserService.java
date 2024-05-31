package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.User;
import com.example.demo.models.view.UserDTO;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public UserDTO assignRole(Long userId, String role) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setRoles(Arrays.asList(roleRepo.findByName(role)));
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

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

}