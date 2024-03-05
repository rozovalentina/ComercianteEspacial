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
    public String guardarTipoNave(@RequestParam String nombre, @RequestParam String descripcion) {
        TipoNave tipoNave = new TipoNave();
        tipoNave.setNombre(nombre);
        tipoNaveService.guardarTipoNave(tipoNave);
        return "redirect:/tiposnave";
    }

    // Otros métodos del controlador según sea necesario para editar, eliminar y mostrar detalles de tipos de naves
}
