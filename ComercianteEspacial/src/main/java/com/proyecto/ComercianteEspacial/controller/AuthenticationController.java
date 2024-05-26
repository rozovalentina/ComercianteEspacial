package com.proyecto.ComercianteEspacial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ComercianteEspacial.dto.JwtAuthenticationResponse;
import com.proyecto.ComercianteEspacial.dto.LoginDTO;
import com.proyecto.ComercianteEspacial.dto.UserRegistrationDTO;
import com.proyecto.ComercianteEspacial.service.AuthenticationService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginDTO request) {
        logger.info(request.getNombre());
        logger.info(request.getpassword());
        return ResponseEntity.ok(authenticationService.login(request));
    }
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserRegistrationDTO request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

}
