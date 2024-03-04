package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Planeta;
import com.proyecto.ComercianteEspacial.service.PlanetaService;

@Controller
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("/planetas")
    public String mostrarPlanetas(Model model) {
        model.addAttribute("planetas", planetaService.obtenerTodosLosPlanetas());
        return "lista_planetas";
    }

    @GetMapping("/planetas/nuevo")
    public String mostrarFormularioNuevoPlaneta() {
        return "formulario_planeta";
    }

    @PostMapping("/planetas/nuevo")
    public String guardarPlaneta(@RequestParam String nombre) {
        Planeta planeta = new Planeta();
        planeta.setNombre(nombre);
        planetaService.guardarPlaneta(planeta);
        return "redirect:/planetas";
    }

    @GetMapping("/planetas/{id}")
    public String mostrarDetallesPlaneta(@PathVariable Long id, Model model) {
        Planeta planeta = planetaService.obtenerPlanetaPorId(id);
        model.addAttribute("planeta", planeta);
        return "detalles_planeta";
    }

    @GetMapping("/planetas/{id}/editar")
    public String mostrarFormularioEditarPlaneta(@PathVariable Long id, Model model) {
        Planeta planeta = planetaService.obtenerPlanetaPorId(id);
        model.addAttribute("planeta", planeta);
        return "formulario_editar_planeta";
    }

    @PostMapping("/planetas/{id}/editar")
    public String editarPlaneta(@PathVariable Long id, @RequestParam String nombre) {
        Planeta planeta = planetaService.obtenerPlanetaPorId(id);
        planeta.setNombre(nombre);
        planetaService.guardarPlaneta(planeta);
        return "redirect:/planetas";
    }

    @PostMapping("/planetas/{id}/eliminar")
    public String eliminarPlaneta(@PathVariable Long id) {
        planetaService.eliminarPlanetaPorId(id);
        return "redirect:/planetas";
    }
}
