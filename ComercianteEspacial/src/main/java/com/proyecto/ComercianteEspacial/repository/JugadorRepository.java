package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
