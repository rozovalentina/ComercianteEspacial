package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Estrella;

@Repository
public interface EstrellaRepository extends JpaRepository<Estrella, Long> {
    @SuppressWarnings("null")
    Page<Estrella> findAll(Pageable pageable);
}
