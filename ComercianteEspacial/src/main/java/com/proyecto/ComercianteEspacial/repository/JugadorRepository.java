package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    @SuppressWarnings("null")
    Page<Jugador> findAll(Pageable pageable);
    @Query("SELECT j FROM Jugador j WHERE j.nombre LIKE %:nombre%")
    Jugador findbyName(String nombre);
}
