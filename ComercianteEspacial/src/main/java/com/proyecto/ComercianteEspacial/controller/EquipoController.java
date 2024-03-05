package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public String getAllEquipos(Model model) {
        List<Equipo> equipos = equipoService.getAllEquipos();
        model.addAttribute("equipos", equipos);
        return "equipos";
    }

    @GetMapping("/{id}")
    public String getEquipoById(@PathVariable("id") Long id, Model model) {
        Equipo equipo = equipoService.getEquipoById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de equipo no válido: " + id));
        model.addAttribute("equipo", equipo);
        return "equipo-detalle";
    }

    @GetMapping("/nuevo")
    public String showEquipoForm(Model model) {
        model.addAttribute("equipo", new Equipo(null));
        return "equipo-formulario";
    }

    @PostMapping("/guardar")
    public String saveEquipo(@ModelAttribute("equipo") Equipo equipo) {
        equipoService.saveEquipo(equipo);
        return "redirect:/equipos";
    }

    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Equipo equipo = equipoService.getEquipoById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de equipo no válido: " + id));
        model.addAttribute("equipo", equipo);
        return "equipo-formulario";
    }

    @GetMapping("/{id}/eliminar")
    public String deleteEquipo(@PathVariable("id") Long id) {
        equipoService.deleteEquipo(id);
        return "redirect:/equipos";
    }
}
