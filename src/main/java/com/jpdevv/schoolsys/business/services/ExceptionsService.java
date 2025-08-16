package com.jpdevv.schoolsys.business.services;

import org.springframework.stereotype.Service;

@Service
public class ExceptionsService {

    public void throwIfStudentExists(String registration) {
        throw new IllegalArgumentException("O aluno com a matrícula '" + registration + "' já existe.");
    }

    public void throwIfStudentNotFound(String registration) {
        throw new IllegalArgumentException("O aluno com a matrícula '" + registration + "' não existe.");
    }

    public void throwNameAlreadyExists(String name) {
        throw new IllegalArgumentException("A disciplina com o nome '" + name + "' já existe.");
    }

    public void throwCodeAlreadyExists(String code) {
        throw new IllegalArgumentException("A disciplina com o código '" + code + "' já existe.");
    }

    public void throwDisciplineNotFound(String code) {
        throw new IllegalArgumentException("A disciplina com o código '" + code + "' não existe.");
    }

}
