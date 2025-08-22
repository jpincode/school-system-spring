package com.jpdevv.schoolsys.business.dto;

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

    public DisciplineDTO(String code, String name, String workload) {
        this.code = code;
        this.name = name;
        this.workload = workload;
    }

}
