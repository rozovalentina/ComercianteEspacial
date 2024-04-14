package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public List<Planeta> obtenerTodosLosPlanetas() {
        return planetaRepository.findAll();
    }

    public Planeta obtenerPlanetaPorId(Long id) {
        return planetaRepository.findById(id).orElse(null);
    }

    public Planeta guardarPlaneta(Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    public void eliminarPlanetaPorId(Long id) {
        planetaRepository.deleteById(id);
    }
}
