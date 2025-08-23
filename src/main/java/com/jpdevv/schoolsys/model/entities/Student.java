package com.jpdevv.schoolsys.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    private String registration;
    private String email;
    private String address;

    public Student() {
        // Default constructor for JPA
    }

    public Student(String registration, String name, String email, String address) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
