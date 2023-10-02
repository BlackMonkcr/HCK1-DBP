package com.example.hck1dbp.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck1dbp.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno,Long>{
}
