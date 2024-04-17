package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public Page<Planeta> obtenerTodosLosPlanetas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return planetaRepository.findAll(pageable);
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
