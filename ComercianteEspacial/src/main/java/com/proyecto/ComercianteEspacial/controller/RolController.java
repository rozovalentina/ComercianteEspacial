package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Rol;
import com.proyecto.ComercianteEspacial.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("")
    public ResponseEntity<List<Rol>> obtenerTodosLosRoles() {
        List<Rol> roles = rolService.obtenerTodosLosRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Rol rol = rolService.obtenerRolPorId(id);
        if (rol != null) {
            return new ResponseEntity<>(rol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardarRol(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

   

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRolPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
