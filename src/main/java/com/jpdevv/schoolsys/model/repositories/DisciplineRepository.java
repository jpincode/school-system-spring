package com.jpdevv.schoolsys.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpdevv.schoolsys.model.entities.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    public Optional<Discipline> findByCode(String code);

    public Optional<Discipline> findByName(String name);
}
