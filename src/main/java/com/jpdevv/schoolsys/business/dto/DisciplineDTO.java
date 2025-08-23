package com.jpdevv.schoolsys.business.dto;

import java.util.List;

import jakarta.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "disciplines")
    private List<StudentDTO> students;

    public DisciplineDTO(String code, String name, String workload) {
        this.code = code;
        this.name = name;
        this.workload = workload;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "DisciplineDTO [id=" + id + ", code=" + code + ", name=" + name + ", workload=" + workload + "]";
    }

}
