package com.example.hck1dbp.domain;

import com.example.hck1dbp.Infrastructure.AlumnoRepository;
import com.example.hck1dbp.Infrastructure.GradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository, GradeRepository gradeRepository) {
        this.alumnoRepository = alumnoRepository;
        this.gradeRepository = gradeRepository;
    }

    void saveNewGrades(Alumno alumno) {
        List<Grade> grades = alumno.getGrades();
        for (int i = 0; i < grades.size(); i++) {
            grades.get(i).setAlumno(alumno);
            gradeRepository.save(grades.get(i));
        }

        alumno.setGrades(grades);
        alumnoRepository.save(alumno);
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    public void addAlumno(Alumno alumno) {
        saveNewGrades(alumno);
    }
}