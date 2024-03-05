package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.repository.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo getEquipoById(Long id) {
        @SuppressWarnings("null")
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        return optionalEquipo.orElse(null);
    }

    @SuppressWarnings("null")
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Long id, Equipo equipo) {
        @SuppressWarnings("null")
        Equipo Eq = equipoRepository.findById(equipo.getId()).orElseThrow();
        Eq.setId(id);
        Eq.setNombre(equipo.getNombre());
        Eq.setDinero(equipo.getDinero());
        return equipoRepository.save(Eq);
    }

    @SuppressWarnings("null")
    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    public void saveEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }
}
