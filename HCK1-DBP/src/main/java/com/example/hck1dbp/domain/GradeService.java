package com.example.hck1dbp.domain;

import com.example.hck1dbp.Infrastructure.GradeRepository;
import com.example.hck1dbp.Infrastructure.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final AlumnoRepository alumnoRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(AlumnoRepository alumnoRepository, GradeRepository gradeRepository) {
        this.alumnoRepository = alumnoRepository;
        this.gradeRepository = gradeRepository;
    }

    void saveNewGrades(Alumno alumno) {
        List<Grade> grades = alumno.getGrades();
        for (int i = 0; i < grades.size(); i++) {
            for (int j = i + 1; j < grades.size(); j++) {
                if (grades.get(i).equals(grades.get(j))) {
                    grades.remove(j);
                    j--;
                }
            }
            grades.get(i).setSeller(alumno);
            gradeRepository.save(grades.get(i));
        }

        alumno.setGrades(grades);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Alumno> getGradeById(Long id) {
        return alumnoRepository.findById(id);
    }
}