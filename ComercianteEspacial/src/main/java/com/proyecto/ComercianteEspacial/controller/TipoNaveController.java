package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.TipoNave;
import com.proyecto.ComercianteEspacial.service.TipoNaveService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/tiposnave")
public class TipoNaveController {

    @Autowired
    private TipoNaveService tipoNaveService;

    @GetMapping("")
    public List<TipoNave> mostrarTiposNaves() {
        return tipoNaveService.obtenerTodosLosTiposNaves();
    }

    @PostMapping("/nuevo")
    public TipoNave guardarTipoNave(@RequestParam String nombre, @RequestParam String descripcion) {
        TipoNave tipoNave = new TipoNave();
        tipoNave.setNombre(nombre);
        return tipoNaveService.guardarTipoNave(tipoNave);
    }
}
