package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.service.EquipoService;


@RestController
@RequestMapping("/equipos")
@CrossOrigin("http://localhost:4200")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("")
    public Page<Equipo> mostrarEquipos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return equipoService.obtenerTodosLosEquipos(page, size);
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable("id") Long id) {
        return equipoService.getEquipoById(id);
    }

    @PostMapping("/guardar")
    public Equipo saveEquipo(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.updateEquipo(id, equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable("id") Long id) {
        equipoService.deleteEquipo(id);
    }
}
