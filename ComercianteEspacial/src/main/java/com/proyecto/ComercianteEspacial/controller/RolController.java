package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.proyecto.ComercianteEspacial.service.RolService;

@Controller
public class RolController {
    @Autowired 
    private RolService rolService;
    
}
