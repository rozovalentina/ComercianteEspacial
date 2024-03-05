package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyecto.ComercianteEspacial.model.TipoNave;
import com.proyecto.ComercianteEspacial.service.TipoNaveService;

@Controller
public class TipoNaveController {

    @Autowired
    private TipoNaveService tipoNaveService;

    @GetMapping("/tiposnave")
    public String mostrarTiposNaves(Model model) {
        model.addAttribute("tiposnave", tipoNaveService.obtenerTodosLosTiposNaves());
        return "lista_tiposnave";
    }

    @GetMapping("/tiposnave/nuevo")
    public String mostrarFormularioNuevoTipoNave() {
        return "formulario_tiponave";
    }

    @PostMapping("/tiposnave/nuevo")
    public String guardarTipoNave(@RequestParam String nombre) {
        TipoNave tipoNave = new TipoNave();
        tipoNave.setNombre(nombre);
        tipoNaveService.guardarTipoNave(tipoNave);
        return "redirect:/tiposnave";
    }

    @GetMapping("/tiposnave/{id}")
    public String mostrarDetallestiposnave(@PathVariable Long id, Model model) {
        TipoNave tipoNave = tipoNaveService.obtenerTipoNavePorId(id);
        model.addAttribute("tipoNave", tipoNave);
        return "detalles_tiponave";
    }

    @GetMapping("/tiposnave/{id}/editar")
    public String mostrarFormularioEditartiposnave(@PathVariable Long id, Model model) {
        TipoNave tipoNave = tipoNaveService.obtenerTipoNavePorId(id);
        model.addAttribute("tipoNave", tipoNave);
        return "formulario_editar_tiponave";
    }

    @PostMapping("/tiposnave/{id}/editar")
    public String editartiposnave(@PathVariable Long id, @RequestParam String nombre) {
        TipoNave tipoNave = tipoNaveService.obtenerTipoNavePorId(id);
        tipoNave.setNombre(nombre);
        tipoNaveService.guardarTipoNave(tipoNave);
        return "redirect:/tiposnave";
    }

    @PostMapping("/tiposnave/{id}/eliminar")
    public String eliminarTipoNave(@PathVariable Long id) {
        tipoNaveService.eliminarTipoNavePorId(id);
        return "redirect:/tiposnave";
    }

    // Otros métodos del controlador según sea necesario para editar, eliminar y mostrar detalles de tipos de naves
}
