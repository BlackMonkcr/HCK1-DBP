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

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }
}