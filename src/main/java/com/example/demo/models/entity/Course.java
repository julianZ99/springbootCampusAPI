package com.example.demo.models.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "course_id", nullable = false)
    private Long id;

    @Column (name = "code", nullable = false)
    private String courseCode;

    @Column (name = "name", nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;

    @OneToMany(mappedBy = "course")
    private Set<Assignment> assignments;

}