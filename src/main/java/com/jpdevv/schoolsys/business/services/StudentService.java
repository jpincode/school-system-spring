package com.jpdevv.schoolsys.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jpdevv.schoolsys.business.dto.StudentDTO;
import com.jpdevv.schoolsys.model.entities.Student;
import com.jpdevv.schoolsys.model.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExceptionsService exceptionsService;
    @Autowired
    private ConverterService converterService;

    public boolean addStudent(StudentDTO studentDTO) {
        Optional<Student> existingStudent = studentRepository.findByRegistration(studentDTO.getRegistration());
        if (existingStudent.isPresent()) {
            exceptionsService.throwIfStudentExists(studentDTO.getRegistration());
            return false;
        }

        Student student = converterService.toStudent(studentDTO);

        studentRepository.save(student);
        return true;
    }
    
    @Transactional
    public boolean updateStudent(StudentDTO studentDTO) {
        Optional<Student> existingStudent = studentRepository.findByRegistration(studentDTO.getRegistration());
        if (existingStudent.isEmpty()) {
            exceptionsService.throwIfStudentNotFound(studentDTO.getRegistration());
            return false;
        }

        Student student = existingStudent.get();
        
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
        return true;
    }

    @Transactional
    public boolean deleteStudent(String registration) {
        Optional<Student> student = studentRepository.findByRegistration(registration);
        if (student.isEmpty()) {
            exceptionsService.throwIfStudentNotFound(registration);
            return false;
        }

        studentRepository.delete(student.get());
        return true;
    }

    public List<StudentDTO> findAll() {
        List<StudentDTO> studentsDTO = new ArrayList<>();

        studentRepository.findAll().forEach(students -> {
            StudentDTO studentDTO = converterService.toStudentDTO(students);
            studentsDTO.add(studentDTO);
        });

        return studentsDTO;
    }
}
