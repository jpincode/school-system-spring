package com.jpdevv.school_system.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpdevv.school_system.models.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByRegistration(String registration);

    public Student findByEmail(String email);
}
