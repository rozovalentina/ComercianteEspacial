package com.proyecto.ComercianteEspacial.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.ComercianteEspacial.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.nave.id = :idNave")
    Page<Usuario>findByNaveId(@Param("idNave") Long idNave, Pageable pageable);

    Optional<Usuario> findByNombre(String nombre);
}
