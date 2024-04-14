package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/navigation")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @GetMapping("/nearest-stars")
    public List<Estrella> getNearestStars(@RequestParam("naveX") double naveX,
                                          @RequestParam("naveY") double naveY,
                                          @RequestParam("naveZ") double naveZ) {
        return navigationService.getNearestStars(naveX, naveY, naveZ);
    }
}
