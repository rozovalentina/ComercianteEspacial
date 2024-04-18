package com.proyecto.ComercianteEspacial.controller;
import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.service.OtherShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class OtherShipInfoController {

    @Autowired
    private OtherShipInfoService otherShipInfoService;

    @GetMapping("/player/{playerId}/other")
    public ResponseEntity<List<Nave>> getOtherShipsInSameStar(@PathVariable Long playerId) {
        List<Nave> otherShips = otherShipInfoService.getOtherShipsInSameStar(playerId);
        if (!otherShips.isEmpty()) {
            return new ResponseEntity<>(otherShips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
