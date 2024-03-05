package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("")
    public String mostrarListaJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.obtenerTodosLosJugadores());
        return "lista_jugadores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "formulario_jugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute("jugador") Jugador jugador) {
        jugadorService.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarJugador(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorService.obtenerJugadorPorId(id);
        model.addAttribute("jugador", jugador);
        return "jugador_edit";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugadorPorId(id);
        return "redirect:/jugadores";
    }
    @PostMapping("/actualizar/{id}")
    public String actualizarJugadoString(@PathVariable Long id,@ModelAttribute("jugador") Jugador jugador) {
        jugadorService.actualizarJugador(id,jugador);
        return "redirect:/jugadores";
    }
    
}
