package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public Page<Jugador> obtenerTodosLosJugadores(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return jugadorService.obtenerTodosLosJugadores(page, size);
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
