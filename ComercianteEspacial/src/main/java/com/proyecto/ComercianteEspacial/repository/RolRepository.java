package com.proyecto.ComercianteEspacial.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
