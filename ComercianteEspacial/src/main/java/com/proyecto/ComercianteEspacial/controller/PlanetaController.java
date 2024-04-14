package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.service.PlanetaService;

import java.util.List;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("")
    public List<Planeta> mostrarPlanetas() {
        return planetaService.obtenerTodosLosPlanetas();
    }

    @PostMapping("/nuevo")
    public Planeta guardarPlaneta(@RequestParam String nombre) {
        Planeta planeta = new Planeta();
        planeta.setNombre(nombre);
        return planetaService.guardarPlaneta(planeta);
    }

    @GetMapping("/{id}")
    public Planeta mostrarDetallesPlaneta(@PathVariable Long id) {
        return planetaService.obtenerPlanetaPorId(id);
    }

    @PutMapping("/{id}")
    public Planeta editarPlaneta(@PathVariable Long id, @RequestParam String nombre) {
        Planeta planeta = planetaService.obtenerPlanetaPorId(id);
        planeta.setNombre(nombre);
        return planetaService.guardarPlaneta(planeta);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlaneta(@PathVariable Long id) {
        planetaService.eliminarPlanetaPorId(id);
    }
}
