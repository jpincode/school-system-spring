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

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        boolean response = studentService.addStudent(studentDTO);
        if(!response) {
            return new ResponseEntity<>("Could not add student!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Student '" + studentDTO.getName() + "' added successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDTO) {
        boolean response = studentService.updateStudent(studentDTO);
        if(!response) {
            return new ResponseEntity<>("Could not update student!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Student '" + studentDTO.getName() + "' updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{registration}")
    public ResponseEntity<String> deleteStudent(@PathVariable String registration) {
        boolean response = studentService.deleteStudent(registration);
        if(!response) {
            return new ResponseEntity<>("Could not delete student!", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Student with registration '" + registration + "' deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> students = studentService.findAll();
        return students;
    }
    
}
