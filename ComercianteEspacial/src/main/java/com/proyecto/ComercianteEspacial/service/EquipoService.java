package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public Page<Equipo> obtenerTodosLosEquipos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return equipoRepository.findAll(pageable);
    }

    public Equipo getEquipoById(Long id) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        return optionalEquipo.orElse(null);
    }

    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Long id, Equipo equipo) {
        Equipo Eq = equipoRepository.findById(id).orElse(null);
        if (Eq != null) {
            Eq.setId(id);
            Eq.setNombre(equipo.getNombre());
            Eq.setDinero(equipo.getDinero());
            return equipoRepository.save(Eq);
        } else {
            return null;
        }
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
