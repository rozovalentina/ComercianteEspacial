package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("")
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
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
