package com.jpdevv.schoolsys.business.services;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    }

    public boolean isValidAge(int age) {
        return age >= 3 && age <= 100;
    }

    public boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }
}
