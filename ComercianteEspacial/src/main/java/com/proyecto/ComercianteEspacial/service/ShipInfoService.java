package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipInfoService {

    @Autowired
    private JugadorService jugadorService;

    public Nave getPlayerShipInfo(Long playerId) {
        // Obtener la información de la nave del jugador a partir del ID del jugador
        // Por simplicidad, se asumirá que el jugador tiene asociada una única nave 
        // Si el jugador no tiene asociada ninguna nave, se devolverá null

        // Obtener el jugador del servicio utilizando el ID del jugador
        Jugador jugador = jugadorService.obtenerJugadorPorId(playerId);
        
        // Verificar si se encontró un jugador con el ID proporcionado
        if (jugador != null) {
            // Obtener la nave asociada al jugador
            return jugador.getNave();
        } else {
            // Devolver null si no se encontró ningún jugador con el ID proporcionado
            return null;
        }
    }
}
