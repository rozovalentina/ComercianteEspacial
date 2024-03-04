package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import java.util.List;

public interface EstrellaService {
    List<Estrella> obtenerTodasEstrellas();
    Estrella obtenerEstrellaPorId(Long id);
    Estrella guardarEstrella(Estrella estrella);
    Estrella actualizarEstrella(Long id, Estrella estrella);
    void eliminarEstrella(Long id);
}
