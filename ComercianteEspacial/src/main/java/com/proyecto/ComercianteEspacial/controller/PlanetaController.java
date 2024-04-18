package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.service.PlanetaService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("")
    public Page<Planeta> mostrarPlanetas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return planetaService.obtenerTodosLosPlanetas(page, size);
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
