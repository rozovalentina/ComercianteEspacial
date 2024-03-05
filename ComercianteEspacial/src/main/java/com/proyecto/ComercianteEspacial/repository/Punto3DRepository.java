package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Punto3D;

@Repository
public interface Punto3DRepository extends JpaRepository<Punto3D, Long> {
}