package com.example.demo.models.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "careers")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "career_id", nullable = false)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "career")
    private Set<User> students;

    @OneToMany(mappedBy = "career")
    private Set<Course> courses;
}