package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.service.EstrellaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estrellas")
public class EstrellaController {

    @Autowired
    private EstrellaService estrellaService;

    @GetMapping("")
    public String mostrarListaEstrellas(Model model) {
        List<Estrella> estrellas = estrellaService.obtenerTodasEstrellas();
        model.addAttribute("estrellas", estrellas);
        return "estrella-list";
    }

    @GetMapping("/{id}")
    public String mostrarDetalleEstrella(@PathVariable Long id, Model model) {
        Estrella estrella = estrellaService.obtenerEstrellaPorId(id);
        model.addAttribute("estrella", estrella);
        return "estrella-detail";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaEstrella(Model model) {
        model.addAttribute("estrella", new Estrella());
        return "estrella-create";
    }

    @PostMapping("/guardar")
    public String guardarEstrella(@ModelAttribute("estrella") Estrella estrella) {
        estrellaService.guardarEstrella(estrella);
        return "redirect:/estrellas";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarEstrella(@PathVariable Long id, Model model) {
        Estrella estrella = estrellaService.obtenerEstrellaPorId(id);
        model.addAttribute("estrella", estrella);
        return "estrella-edit";
    }

    @PutMapping("/{id}/actualizar")
    public String actualizarEstrella(@PathVariable Long id, @ModelAttribute("estrella") Estrella estrella) {
        estrellaService.actualizarEstrella(id, estrella);
        return "redirect:/estrellas";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarEstrella(@PathVariable Long id) {
        estrellaService.eliminarEstrella(id);
        return "redirect:/estrellas";
    }
}
