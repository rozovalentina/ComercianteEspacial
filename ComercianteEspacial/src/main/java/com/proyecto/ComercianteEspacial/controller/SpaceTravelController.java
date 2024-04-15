package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.service.SpaceTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class SpaceTravelController {

    @Autowired
    private SpaceTravelService spaceTravelService;

    @PostMapping("/initiate")
    public void initiateSpaceTravel(@RequestParam Long starId) {
        spaceTravelService.initiateSpaceTravel(starId);
    }
}
