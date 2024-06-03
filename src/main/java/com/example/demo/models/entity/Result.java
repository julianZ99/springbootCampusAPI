package com.example.demo.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "course_results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "result_id", nullable = false)
    private Long result_id;

    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt;

    @OneToOne
    @JoinColumn(name = "registration_id", nullable = false, unique = true)
    private Registration registration;
}
