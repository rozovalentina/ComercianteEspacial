package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Page<Jugador> obtenerTodosLosJugadores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return jugadorRepository.findAll(pageable);
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

    public Jugador actualizarJugador(Long id, Jugador jugador) {
        Jugador ju = jugadorRepository.findById(id).orElse(null);
        if (ju != null) {
            ju.setNombre(jugador.getNombre());
            ju.setpassword(jugador.getPassword());
            return jugadorRepository.save(ju);
        } else {
            return null;
        }
    }

    public Jugador authenticate(String nombre, String contraseña) {
        return jugadorRepository.findbyName(nombre);
    }
}
