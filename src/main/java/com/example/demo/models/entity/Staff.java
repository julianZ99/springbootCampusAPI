package com.example.demo.models.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Staff extends User {
    private int cuil;

    @ManyToMany
    @JoinTable(
        name = "staff_courses",
        joinColumns = @JoinColumn(name = "staff_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
        course.getStaff().add(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStaff().remove(this);
    }
}