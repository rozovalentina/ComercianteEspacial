package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador obtenerJugadorPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador guardarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void eliminarJugadorPorId(Long id) {
        jugadorRepository.deleteById(id);
    }

    public Jugador actualizarJugador(Long id,Jugador jugador){
        Jugador ju= jugadorRepository.findById(id).orElseThrow();
        ju.setNombre(jugador.getNombre());
        ju.setRol(jugador.getRol());
        ju.setContraseña(jugador.getContraseña());
        return jugadorRepository.save(ju);
    }
}
