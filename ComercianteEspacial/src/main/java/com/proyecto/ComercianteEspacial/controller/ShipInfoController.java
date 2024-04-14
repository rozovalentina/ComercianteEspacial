package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.service.ShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ship-info")
public class ShipInfoController {

    @Autowired
    private ShipInfoService shipInfoService;

    @GetMapping("/{playerId}")
    public Equipo getPlayerShipInfo(@PathVariable Long playerId) {
        return shipInfoService.getPlayerShipInfo(playerId);
    }
}
