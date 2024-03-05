package com.proyecto.ComercianteEspacial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    static List<Rol> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
