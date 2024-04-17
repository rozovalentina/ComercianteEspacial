package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.ComercianteEspacial.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    Page<Equipo> findAll(Pageable pageable);
}
