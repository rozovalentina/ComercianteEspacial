package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Jugador jugador) {
        // Verificar las credenciales del jugador en la base de datos
        boolean authenticated = jugadorService.authenticate(jugador.getNombre(), jugador.getContraseña());
        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
