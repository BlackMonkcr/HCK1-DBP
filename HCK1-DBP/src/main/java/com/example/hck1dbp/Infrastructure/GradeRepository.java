package com.example.hck1dbp.infrastructure;

import com.example.hck1dbp.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck1dbp.domain.Grade;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long>{}
