package com.jpdevv.schoolsys.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jpdevv.schoolsys.business.dto.DisciplineDTO;
import com.jpdevv.schoolsys.model.entities.Discipline;
import com.jpdevv.schoolsys.model.repositories.DisciplineRepository;

import jakarta.transaction.Transactional;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;
    private final ExceptionsService exceptionsService;
    private final ConverterService converterService;

    public DisciplineService(DisciplineRepository disciplineRepository, ExceptionsService exceptionsService, ConverterService converterService) {
        this.disciplineRepository = disciplineRepository;
        this.exceptionsService = exceptionsService;
        this.converterService = converterService;
    }

    public void addDiscipline(DisciplineDTO disciplineDTO) {
        Optional<Discipline> existingName = disciplineRepository.findByName(disciplineDTO.getName());
        Optional<Discipline> existingCode = disciplineRepository.findByCode(disciplineDTO.getCode());
        if (existingName.isPresent()) {
            exceptionsService.throwNameAlreadyExists(disciplineDTO.getName());
        }
        if (existingCode.isPresent()) {
            exceptionsService.throwCodeAlreadyExists(disciplineDTO.getCode());
        }

        Discipline discipline = converterService.toDiscipline(disciplineDTO);

        disciplineRepository.save(discipline);
    }

    @Transactional
    public void updateDiscipline(DisciplineDTO disciplineDTO) {
        Optional<Discipline> existingDiscipline = disciplineRepository.findByCode(disciplineDTO.getCode());
        if (existingDiscipline.isEmpty()) {
            exceptionsService.throwDisciplineNotFound(disciplineDTO.getCode());
        }

        Discipline discipline = existingDiscipline.get();
        
        if(StringUtils.hasText(disciplineDTO.getName()) && !disciplineDTO.getName().equals(discipline.getName())) {
            discipline.setName(disciplineDTO.getName());
        }
        if(disciplineDTO.getWorkload() != null && !disciplineDTO.getWorkload().equals(discipline.getWorkload())) {
            discipline.setWorkload(disciplineDTO.getWorkload());
        }

        disciplineRepository.save(discipline);
    }

    @Transactional
    public void deleteDiscipline(String code) {
        Optional<Discipline> discipline = disciplineRepository.findByCode(code);
        if (discipline.isEmpty()) {
            exceptionsService.throwDisciplineNotFound(code);
        }

        disciplineRepository.delete(discipline.get());
    }

    public List<DisciplineDTO> findAll() {
        List<DisciplineDTO> disciplinesDTO = new ArrayList<>();

        disciplineRepository.findAll().forEach(disciplines -> {
            DisciplineDTO disciplineDTO = converterService.toDisciplineDTO(disciplines);
            disciplinesDTO.add(disciplineDTO);
        });

        return disciplinesDTO;
    }
}
