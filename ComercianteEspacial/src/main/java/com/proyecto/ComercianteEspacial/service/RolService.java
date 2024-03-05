package com.proyecto.ComercianteEspacial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ComercianteEspacial.model.Rol;
import com.proyecto.ComercianteEspacial.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;


    public Rol obtenerRolPorId(Long id){
        Optional <Rol> rol = this.rolRepository.findById(id);
        return rol.orElseThrow(null);
    }
}
