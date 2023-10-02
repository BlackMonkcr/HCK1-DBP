package com.example.hck1dbp.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alumno_id", nullable = false, unique = true)
    private Long id;

    private String LastName;

    private String code;

    @OneToMany(mappedBy = "alumno")
    private List<Grade> grades;

    /* ---------------------------------------------------------------------------------------- */

    // Constructors
    public Alumno() {
    }

    public Alumno(String LastName, String code, List<Grade> grades) {
        this.grades = grades;
        this.LastName = LastName;
        this.code = code;
    }

    /* ---------------------------------------------------------------------------------------- */

    // Getters
    public Long getId() {
        return id;
    }

    public String getLastName() {
        return LastName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    /* ---------------------------------------------------------------------------------------- */

    // Setters
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}