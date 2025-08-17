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
    
    @PostMapping("/add")
    public ResponseEntity<String> addDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        disciplineService.addDiscipline(disciplineDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Discipline '" + disciplineDTO.getName() + "' added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        disciplineService.updateDiscipline(disciplineDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Discipline with code '" + disciplineDTO.getCode() + "' updated successfully");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable String code) {
        disciplineService.deleteDiscipline(code);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Discipline with code '" + code + "' deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<DisciplineDTO>> getAllDisciplines() {
        List<DisciplineDTO> disciplines = disciplineService.findAll();
        return ResponseEntity.ok(disciplines);
    }
}
