package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.service.NavigationService;
import com.proyecto.ComercianteEspacial.service.NavigationService.EstrellaConDistancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @GetMapping("/estrellas/cercanas")
    public List<EstrellaConDistancia> getNearestStars(
            @RequestParam double naveX,
            @RequestParam double naveY,
            @RequestParam double naveZ) {
        return navigationService.getNearestStars(naveX, naveY, naveZ);
    }
}
