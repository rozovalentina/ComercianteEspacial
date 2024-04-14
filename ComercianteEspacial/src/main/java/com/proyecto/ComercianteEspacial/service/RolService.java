package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Rol;
import com.proyecto.ComercianteEspacial.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorId(Long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        return rolOptional.orElse(null);
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }



    public void eliminarRolPorId(Long id) {
        rolRepository.deleteById(id);
    }
}
