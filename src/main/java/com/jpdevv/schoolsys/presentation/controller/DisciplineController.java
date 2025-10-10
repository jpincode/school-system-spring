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

import com.jpdevv.schoolsys.business.dto.DisciplineDTO;
import com.jpdevv.schoolsys.business.services.DisciplineService;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    
    @PostMapping
    public ResponseEntity<String> addDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        boolean response = disciplineService.addDiscipline(disciplineDTO);
        if (!response) {
            return new ResponseEntity<>("Could not add discipline!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Discipline with code '" + disciplineDTO.getCode() + "' added successfully", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        boolean response = disciplineService.updateDiscipline(disciplineDTO);
        if (!response) {
            return new ResponseEntity<>("Could not update discipline!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Discipline with code '" + disciplineDTO.getCode() + "' updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable String code) {
        boolean response = disciplineService.deleteDiscipline(code);
        if (!response) {
            return new ResponseEntity<>("Could not delete discipline!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Discipline with code '" + code + "' deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<DisciplineDTO> getAllDisciplines() {
        List<DisciplineDTO> disciplines = disciplineService.findAll();
        return (disciplines);
    }

    @PostMapping("/{code}/{registration}")
    public ResponseEntity<String> enrollStudent(@PathVariable String code, @PathVariable String registration) {
        boolean response = disciplineService.enrollStudent(code, registration);
        if (!response) {
            return new ResponseEntity<>("Could not enroll student!", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Student with registration '" + registration + "' enrolled in discipline with code '" + code + "' successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{code}/{registration}")
    public ResponseEntity<String> unenrollStudent(@PathVariable String code, @PathVariable String registration) {
        boolean response = disciplineService.unenrollStudent(code, registration);
        if (!response) {
            return new ResponseEntity<>("Could not unenroll student!", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Student with registration '" + registration + "' unenrolled from discipline with code '" + code + "' successfully", HttpStatus.OK);
    }
    
}
