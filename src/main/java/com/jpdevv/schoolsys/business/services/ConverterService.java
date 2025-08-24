package com.jpdevv.schoolsys.business.services;

import org.springframework.stereotype.Service;

import com.jpdevv.schoolsys.business.dto.DisciplineDTO;
import com.jpdevv.schoolsys.business.dto.StudentDTO;
import com.jpdevv.schoolsys.model.entities.Discipline;
import com.jpdevv.schoolsys.model.entities.Student;

@Service
public class ConverterService {

    public DisciplineDTO toDisciplineDTO(Discipline d) {
        return new DisciplineDTO(
            d.getCode(), 
            d.getName(), 
            d.getWorkload(),
            d.getStudents().stream().map(this::toStudentDTO).toList()
        );
    }

    public Discipline toDiscipline(DisciplineDTO d) {
        return new Discipline(
            d.getCode(), 
            d.getName(), 
            d.getWorkload()
        );
    }

    public StudentDTO toStudentDTO(Student s) {
        return new StudentDTO(
            s.getRegistration(), 
            s.getName(), 
            s.getEmail(), 
            s.getAddress()
        );
    }
    
    public Student toStudent(StudentDTO s) {
        return new Student(
            s.getRegistration(), 
            s.getName(), 
            s.getEmail(), 
            s.getAddress()
        );
    }
}
