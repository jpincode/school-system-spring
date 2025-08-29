package com.jpdevv.schoolsys.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpdevv.schoolsys.business.dto.DisciplineDTO;
import com.jpdevv.schoolsys.business.services.DisciplineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    
    @PostMapping("/disciplines")
    public String addDiscipline(@RequestBody DisciplineDTO disciplineDTO) {

        disciplineService.addDiscipline(disciplineDTO);
        return "Discipline '" + disciplineDTO.getName() + "' added successfully";
    }

    @PutMapping("/disciplines")
    public String updateDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        disciplineService.updateDiscipline(disciplineDTO);
        return ("Discipline with code '" + disciplineDTO.getCode() + "' updated successfully");
    }

    @DeleteMapping("/disciplines/{code}")
    public String deleteDiscipline(@PathVariable String code) {
        disciplineService.deleteDiscipline(code);
        return ("Discipline with code '" + code + "' deleted successfully");
    }

    @GetMapping("/disciplines")
    public List<DisciplineDTO> getAllDisciplines() {
        List<DisciplineDTO> disciplines = disciplineService.findAll();
        return (disciplines);
    }

    @PostMapping("/{code}/students/{registration}")
    public String enrollStudent(@PathVariable String code, @PathVariable String registration) {
        disciplineService.enrollStudent(code, registration);
        
        return ("Student with registration '" + registration + "' enrolled in discipline with code '" + code + "' successfully");
    }

    @DeleteMapping("/{code}/students/{registration}")
    public String unenrollStudent(@PathVariable String code, @PathVariable String registration) {
        disciplineService.unenrollStudent(code, registration);
        
        return ("Student with registration '" + registration + "' unenrolled from discipline with code '" + code + "' successfully");
    }
    
}
