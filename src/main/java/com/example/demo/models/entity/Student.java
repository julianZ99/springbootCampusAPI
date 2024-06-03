package com.example.demo.models.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;
    
    @OneToMany(mappedBy = "student")
    private List<Registration> registrations;
}
