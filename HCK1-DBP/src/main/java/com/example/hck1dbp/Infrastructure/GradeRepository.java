package com.example.hck1dbp.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck1dbp.domain.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{}
