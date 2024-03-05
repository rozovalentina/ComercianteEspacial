package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.repository.EstrellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstrellaServiceImpl implements EstrellaService {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Override
    public List<Estrella> obtenerTodasEstrellas() {
        return estrellaRepository.findAll();
    }

    @Override
    public Estrella obtenerEstrellaPorId(Long id) {
        @SuppressWarnings("null")
        Optional<Estrella> optionalEstrella = estrellaRepository.findById(id);
        return optionalEstrella.orElse(null);
    }

    @SuppressWarnings("null")
    @Override
    public Estrella guardarEstrella(Estrella estrella) {
        return estrellaRepository.save(estrella);
    }

    @Override
    public Estrella actualizarEstrella(Long id, Estrella estrella) {
        Estrella es = estrellaRepository.findById(estrella.getId()).orElseThrow();
        es.setId(id);
        es.setCoordenadaX(estrella.getCoordenadaX());
        es.setCoordenadaY(estrella.getCoordenadaY());
        es.setCoordenadaX(estrella.getCoordenadaX());
        es.setCoordenadaZ(estrella.getCoordenadaZ());
        es.setHabitada(estrella.isHabitada());
        es.setNombre(estrella.getNombre());
        return estrellaRepository.save(es);
    }

    @SuppressWarnings("null")
    @Override
    public void eliminarEstrella(Long id) {
        estrellaRepository.deleteById(id);
    }

    public List<Planeta> obtenerTodoslosPlanetas( Estrella estrella) {
        List<Planeta> pl = estrella.getPlanetas();
        return pl; 
    }

}

