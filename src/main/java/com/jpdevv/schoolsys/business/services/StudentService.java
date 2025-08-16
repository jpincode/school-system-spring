package com.jpdevv.schoolsys.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jpdevv.schoolsys.business.dto.StudentDTO;
import com.jpdevv.schoolsys.model.entities.Student;
import com.jpdevv.schoolsys.model.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ExceptionsService exceptionsService;

    public StudentService(StudentRepository studentRepository, ExceptionsService exceptionsService) {
        this.studentRepository = studentRepository;
        this.exceptionsService = exceptionsService;
    }

    public void addStudent(StudentDTO studentDTO) {
        Optional<Student> existingStudent = studentRepository.findByRegistration(studentDTO.getRegistration());
        if (existingStudent.isPresent()) {
            exceptionsService.throwIfStudentExists(studentDTO.getRegistration());
        }

        Student student = new Student(
            studentDTO.getRegistration(),
            studentDTO.getName(),
            studentDTO.getEmail(),
            studentDTO.getAddress()
        );

        studentRepository.save(student);
    }
    
    @Transactional
    public void updateStudent(StudentDTO studentDTO) {
        Optional<Student> existingStudent = studentRepository.findByRegistration(studentDTO.getRegistration());
        if (existingStudent.isEmpty()) {
            exceptionsService.throwIfStudentNotFound(studentDTO.getRegistration());
        }

        Student student = existingStudent.get();
        
        if(StringUtils.hasText(studentDTO.getRegistration()) && !studentDTO.getRegistration().equals(student.getRegistration())) {
            student.setRegistration(studentDTO.getRegistration());
        }
        if(StringUtils.hasText(studentDTO.getName()) && !studentDTO.getName().equals(student.getName())) {
            student.setName(studentDTO.getName());
        }
        if(StringUtils.hasText(studentDTO.getEmail()) && !studentDTO.getEmail().equals(student.getEmail())) {
            student.setEmail(studentDTO.getEmail());
        }
        if(StringUtils.hasText(studentDTO.getAddress()) && !studentDTO.getAddress().equals(student.getAddress())) {
            student.setAddress(studentDTO.getAddress());
        }

        studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(String registration) {
        Optional<Student> student = studentRepository.findByRegistration(registration);
        if (student.isEmpty()) {
            exceptionsService.throwIfStudentNotFound(registration);
        }

        studentRepository.deleteByRegistration(registration);
    }

    public List<StudentDTO> findAll() {
        List<StudentDTO> studentsDTO = new ArrayList<>();

        studentRepository.findAll().forEach(students -> {
            StudentDTO studentDTO = new StudentDTO(
                students.getRegistration(),
                students.getName(),
                students.getEmail(),
                students.getAddress()
            );
            studentsDTO.add(studentDTO);
        });

        return studentsDTO;
    }
}
