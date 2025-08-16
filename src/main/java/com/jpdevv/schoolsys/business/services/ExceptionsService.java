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

    public void throwNameAlreadyExists(String name) {
        throw new IllegalArgumentException("Discipline with name '" + name + "' already exists.");
    }

    public void throwCodeAlreadyExists(String code) {
        throw new IllegalArgumentException("Discipline with code '" + code + "' already exists.");
    }

    public void throwDisciplineNotFound(String code) {
        throw new IllegalArgumentException("Discipline with code '" + code + "' does not exist.");
    }

}
