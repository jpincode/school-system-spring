package com.jpdevv.school_system.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 10)
    private String code, workload;

    public Discipline(String name, String code, String workload) {
        this.name = name;
        this.code = code;
        this.workload = workload;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Discipline [name=").append(name)
          .append(", code=").append(code)
          .append(", workload=").append(workload)
          .append("]\n- Students enrolled:\n");
        
        return sb.toString();
    }
}
