package com.example.hck1dbp.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck1dbp.domain.Alumno;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno,Long>{
}
