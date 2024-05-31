package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

    Role findByName(String name);

}
