package com.proyecto.ComercianteEspacial.repository;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaveRepository extends JpaRepository<Nave, Long> {
    List<Nave> findByEstrella(Estrella estrella);
}
