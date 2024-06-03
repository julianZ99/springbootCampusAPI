package com.example.demo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "assignment_id", nullable = false)
    private Long id;

    @Column (name = "title", nullable = false)
    private String title;

    @Column (name = "description", nullable = false)
    private String description;

    @Column (name = "startDate", nullable = false)
    private String startDate;

    @Column (name = "dueDate", nullable = false)
    private String dueDate;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private User professor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column (name = "status", nullable = false)
    private String status;

    @Column (name = "score")
    private String score;
}
