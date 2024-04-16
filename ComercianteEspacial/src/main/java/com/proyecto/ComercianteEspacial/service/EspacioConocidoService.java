package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioConocidoService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Estrella> getEstrellasVisitadas(Long playerId) {
        // Buscar el jugador por su ID
        Jugador jugador = jugadorRepository.findById(playerId).orElse(null);

        // Verificar si se encontró el jugador y si tiene estrellas visitadas
        if (jugador != null && jugador.getEstrellasVisitadas() != null) {
            return jugador.getEstrellasVisitadas();
        } else {
            // Devolver una lista vacía si no se encontró el jugador o si no tiene estrellas visitadas
            return List.of();
        }
    }
}