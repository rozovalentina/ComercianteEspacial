package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Planeta;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EstrellaService {
    Page<Estrella> obtenerTodasEstrellas(int page,int size);
    Estrella obtenerEstrellaPorId(Long id);
    Estrella guardarEstrella(Estrella estrella);
    Estrella actualizarEstrella(Long id, Estrella estrella);
    void eliminarEstrella(Long id);
    List<Planeta> obtenerTodosLosPlanetas(Long idEstrella);
}
