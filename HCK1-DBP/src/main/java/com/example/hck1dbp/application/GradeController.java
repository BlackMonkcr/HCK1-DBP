package com.example.hck1dbp.application;

import com.example.hck1dbp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeService gradeService;
    private final AlumnoService alumnoService;

    @Autowired
    public GradeController(GradeService gradeService, AlumnoService alumnoService) {
        this.gradeService = gradeService;
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    ResponseEntity getGrades() {
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> gradeOptional = gradeService.getGradeById(id);
        return gradeOptional.map(grade ->
                new ResponseEntity<>(grade, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/alumno/{id}")
    ResponseEntity<List<Grade>> getGradesOfAlumno(@PathVariable Long id) {
        Optional<Alumno> alumnoOptional = alumnoService.getAlumnoById(id);
        if (alumnoOptional.isPresent()) {
            return new ResponseEntity<>(alumnoOptional.get().getGrades(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
