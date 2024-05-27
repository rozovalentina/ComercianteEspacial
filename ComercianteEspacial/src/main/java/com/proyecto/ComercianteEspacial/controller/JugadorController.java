package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CAPITAN', 'PILOTO', 'COMERCIANTE')")
    public Page<Jugador> obtenerTodosLosJugadores(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return jugadorService.obtenerTodosLosJugadores(page, size);
    }
    @PreAuthorize("hasAnyAuthority('CAPITAN', 'PILOTO', 'COMERCIANTE')")
    @GetMapping("/{nombre}")
    public Jugador getJugadorPorNombre(@PathVariable String nombre) {
        return jugadorService.authenticate(nombre, nombre);
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
