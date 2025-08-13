package com.jpdevv.school_system.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpdevv.school_system.models.entities.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    public Discipline findByCode(String code);

    public Discipline findByName(String name);
}
