package com.jpdevv.schoolsys.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpdevv.schoolsys.model.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<Student> findByRegistration(String registration);

    public Optional<Student> findByEmail(String email);

    public void deleteByRegistration(String registration);
}
