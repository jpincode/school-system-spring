package com.jpdevv.schoolsys.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

    @NotBlank(message = "A matrícula é obrigatória")
    private String registration;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Email(message = "O e-mail deve ser válido")
    private String email;

    @NotBlank(message = "O endereço é obrigatório")
    private String address;

    public StudentDTO(String registration, String name, String email, String address) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.address = address;
    }

}
