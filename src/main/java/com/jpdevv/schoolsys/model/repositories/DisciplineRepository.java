package com.jpdevv.schoolsys.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpdevv.schoolsys.model.entities.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    public Discipline findByCode(String code);

    public Discipline findByName(String name);
}
