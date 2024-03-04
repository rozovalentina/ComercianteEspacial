package com.proyecto.ComercianteEspacial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.TipoNave;
@Repository
public interface TipoNaveRepository extends JpaRepository<TipoNave, Long> {
}