package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.service.EstrellaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/estrellas")
public class EstrellaController {

    @Autowired
    private EstrellaService estrellaService;

    @GetMapping("")
    public Page<Estrella> mostrarListaEstrellas(
        @RequestParam(defaultValue = "0")int page,
        @RequestParam(defaultValue = "10") int size) {
        return estrellaService.obtenerTodasEstrellas(page,size);
    }

    @GetMapping("/{id}")
    public Estrella mostrarDetalleEstrella(@PathVariable Long id) {
        return estrellaService.obtenerEstrellaPorId(id);
    }

    @PostMapping("/guardar")
    public Estrella guardarEstrella(@RequestBody Estrella estrella) {
        return estrellaService.guardarEstrella(estrella);
    }

    @PutMapping("/{id}")
    public Estrella actualizarEstrella(@PathVariable Long id, @RequestBody Estrella estrella) {
        return estrellaService.actualizarEstrella(id, estrella);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstrella(@PathVariable Long id) {
        estrellaService.eliminarEstrella(id);
    }
}
