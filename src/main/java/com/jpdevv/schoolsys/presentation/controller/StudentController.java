package com.jpdevv.schoolsys.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpdevv.schoolsys.business.dto.StudentDTO;
import com.jpdevv.schoolsys.business.services.StudentService;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Student '" + studentDTO.getName() + "' added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Student with registration '" + studentDTO.getRegistration() + "' updated successfully");
    }

    @DeleteMapping("/delete/{registration}")
    public ResponseEntity<String> deleteStudent(@PathVariable String registration) {
        studentService.deleteStudent(registration);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Student with registration '" + registration + "' deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }
    
}
