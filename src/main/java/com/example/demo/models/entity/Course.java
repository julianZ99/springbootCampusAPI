package com.example.demo.models.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private Long id;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;

    @ManyToMany
    @JoinTable(
        name = "course_semesters",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "semester_id")
    )
    private Set<Semester> availableSemesters;

    @ManyToMany
    @JoinTable(
        name = "course_prerequisites",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
    )
    private Set<Course> prerequisites;

    @OneToMany(mappedBy = "course")
    private List<Registration> registrations;

    @ManyToMany
    @JoinTable(
        name = "staff_courses",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private Set<Staff> staff = new HashSet<>();

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
        staffMember.getCourses().add(this);
    }

    public void removeStaff(Staff staffMember) {
        staff.remove(staffMember);
        staffMember.getCourses().remove(this);
    }

}