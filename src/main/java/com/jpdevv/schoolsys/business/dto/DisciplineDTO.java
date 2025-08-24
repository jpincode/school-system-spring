package com.jpdevv.schoolsys.business.dto;

import java.util.List;
import java.util.Optional;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDTO {
    private Long id;

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Workload is required")
    private String workload;

    private List<StudentDTO> students;

    public DisciplineDTO(String code, String name, String workload, List<StudentDTO> students) {
        this.code = code;
        this.name = name;
        this.workload = workload;
        this.students = students;
    }

    public Optional<List<StudentDTO>> getStudents() {
        return Optional.ofNullable(students);
    }

    public void addStudent(StudentDTO student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "DisciplineDTO [code=" + code + ", name=" + name + ", workload=" + workload + "]";
    }

}
