package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Planeta;

import java.util.List;

public interface EstrellaService {
    List<Estrella> obtenerTodasEstrellas();
    Estrella obtenerEstrellaPorId(Long id);
    Estrella guardarEstrella(Estrella estrella);
    Estrella actualizarEstrella(Long id, Estrella estrella);
    void eliminarEstrella(Long id);
    List<Planeta> obtenerTodoslosPlanetas(Estrella estrella );

}
