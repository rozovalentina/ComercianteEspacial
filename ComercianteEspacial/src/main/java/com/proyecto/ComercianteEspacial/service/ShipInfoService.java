package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.model.TipoNave;
import com.proyecto.ComercianteEspacial.repository.NaveRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipInfoService {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private NaveRepository naveRepository;

    public List<Nave> obtenerTodasLasNaves() {
        return naveRepository.findAll();
    }
    public Nave obtenerNavePorId(Long id) {
        return naveRepository.findById(id).orElse(null);
    }
 
    public List<Nave> getOtherShipsInSameStar(Long playerId) {
        // Obtener el jugador a partir de su ID
        Jugador jugador = jugadorService.obtenerJugadorPorId(playerId);

        // Verificar si se encontró un jugador con el ID proporcionado
        if (jugador != null && jugador.getNave() != null) {
            // Obtener la estrella en la que se encuentra la nave del jugador
            Estrella estrella = jugador.getNave().getEstrella();

            // Buscar todas las naves en la misma estrella
            return naveRepository.findByEstrella(estrella);
        } else {
            // Si no se encontró el jugador o la nave del jugador, devolver una lista vacía
            return List.of();
        }
    }
}
