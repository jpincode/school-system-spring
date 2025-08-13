package com.jpdevv.school_system.business.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpdevv.school_system.business.dto.StudentDTO;
import com.jpdevv.school_system.models.entities.Student;
import com.jpdevv.school_system.models.repositories.StudentRepository;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void save(StudentDTO student) {
        Student studentEntity = new Student(
            student.getRegistration(),
            student.getName(),
            student.getEmail(),
            student.getAddress()
        );

        studentRepository.save(studentEntity);
    }

    public Student findByCode(String registration) {
        return studentRepository.findByRegistration(registration);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
