package com.example.hck1dbp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "score", nullable = false)
    private Long score;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id")
    private Alumno alumno;

    /* ---------------------------------------------------------------------------------------- */

    // Constructors
    public Grade() {
    }

    public Grade(Long score, Alumno alumno) {
        this.score = score;
        this.alumno = alumno;
    }

    /* ---------------------------------------------------------------------------------------- */

    // Getters
    public Long getId() {
        return id;
    }

    public Long getScore() {
        return score;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    /* ---------------------------------------------------------------------------------------- */

    // Setters
    public void setScore(Long score) {
        this.score = score;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /* ---------------------------------------------------------------------------------------- */
}