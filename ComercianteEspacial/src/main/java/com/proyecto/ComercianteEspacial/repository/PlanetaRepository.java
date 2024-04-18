package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
    @SuppressWarnings("null")
    Page<Planeta> findAll(Pageable pageable);
}
