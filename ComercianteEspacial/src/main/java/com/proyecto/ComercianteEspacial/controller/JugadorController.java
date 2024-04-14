package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("")
    public List<Jugador> mostrarListaJugadores() {
        return jugadorService.obtenerTodosLosJugadores();
    }

    @PostMapping("/guardar")
    public Jugador guardarJugador(@RequestBody Jugador jugador) {
        return jugadorService.guardarJugador(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        return jugadorService.actualizarJugador(id, jugador);
    }

    @DeleteMapping("/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugadorPorId(id);
    }
}
