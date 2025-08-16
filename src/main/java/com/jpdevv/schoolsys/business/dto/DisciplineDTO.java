package com.jpdevv.schoolsys.business.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDTO {
    @NotBlank(message = "O código é obrigatório")
    private String code;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A carga horária é obrigatória")
    private String workload;

    public DisciplineDTO(String code, String name, String workload) {
        this.code = code;
        this.name = name;
        this.workload = workload;
    }
    
}
