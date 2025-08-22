package com.jpdevv.schoolsys.business.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long id;

    @NotBlank(message = "Registration is required")
    private String registration;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    public StudentDTO(String registration, String name, String email, String address) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.address = address;
    }

}
