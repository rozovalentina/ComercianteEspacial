package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
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

    @SuppressWarnings("null")
    public Optional<Equipo> getEquipoById(Long id) {
        return equipoRepository.findById(id);
    }

    @SuppressWarnings("null")
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Long id, Equipo equipoDetails) {
        @SuppressWarnings("null")
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.setNombre(equipoDetails.getNombre());
            equipo.setDinero(equipoDetails.getDinero());
            // Actualizar otras propiedades si es necesario
            return equipoRepository.save(equipo);
        } else {
            throw new RuntimeException("Equipo no encontrado con el ID: " + id);
        }
    }

    @SuppressWarnings("null")
    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    public void saveEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }
}
