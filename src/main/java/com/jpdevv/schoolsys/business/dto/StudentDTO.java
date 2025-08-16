package com.jpdevv.schoolsys.business.dto;

public class StudentDTO {
    private String registration;
    private String name;
    private String email;
    private String address;

    public StudentDTO(String registration, String name, String email, String address) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
