package com.example.hck1dbp.application;

import com.example.hck1dbp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/alumno")
public class AlumnoController{
  private final AlumnoService alumnoService;

  @Autowired
  public AlumnoController(AlumnoService alumnoService){
    this.alumnoService = alumnoService;
  }

  @GetMapping()
  ResponseEntity<List<Alumno>> getAlumnos(){
    return new ResponseEntity<>(alumnoService.getAllAlumnos(),HttpStatus.OK);
  }

  @GetMapping("/{id}")
  ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id){
    Optional<Alumno> alumnoOptional= alumnoService.getAlumnoById(id);
    return alumnoOptional.map(alumno ->new ResponseEntity<>(alumno, HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/add")
  ResponseEntity<Alumno> PostAlumno(@RequestBody Alumno alumno) {
      alumnoService.addAlumno(alumno);
      return new ResponseEntity<>(alumno, HttpStatus.CREATED);
  }

}
