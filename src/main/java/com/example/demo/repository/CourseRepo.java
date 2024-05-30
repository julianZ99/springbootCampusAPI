package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

}
