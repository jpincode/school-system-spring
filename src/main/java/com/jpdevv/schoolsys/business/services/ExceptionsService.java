package com.jpdevv.schoolsys.business.services;

import org.springframework.stereotype.Service;

@Service
public class ExceptionsService {

    public void throwIfStudentExists(String registration) {
        throw new IllegalArgumentException("Student with registration '" + registration + "' already exists.");
    }

    public void throwIfStudentNotFound(String registration) {
        throw new IllegalArgumentException("Student with registration '" + registration + "' does not exist.");
    }

}
