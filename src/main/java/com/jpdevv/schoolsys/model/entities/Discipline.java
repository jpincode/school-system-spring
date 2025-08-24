package com.jpdevv.schoolsys.model.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 10)
    private String code;
    private String workload;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    public Discipline() {
        // Default constructor for JPA
    }

    public Discipline(String code, String name, String workload) {
        this.code = code;
        this.name = name;
        this.workload = workload;
    }
}
