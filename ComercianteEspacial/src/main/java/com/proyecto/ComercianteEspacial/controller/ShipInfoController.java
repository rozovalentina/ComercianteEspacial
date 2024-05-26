package com.proyecto.ComercianteEspacial.controller;
import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.model.TipoNave;
import com.proyecto.ComercianteEspacial.service.ShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


@RestController
@RequestMapping("/nave")
public class ShipInfoController {

    @Autowired
    private ShipInfoService shipInfoService;

        @GetMapping("")
    @PreAuthorize("hasAnyAuthority('CAPITAN', 'PILOTO', 'COMERCIANTE')")
    public List<Nave> mostrarNaves() {
        return shipInfoService.obtenerTodasLasNaves();
    }
    @GetMapping("/{id}")
    public Nave mostrarDetalleNave(@PathVariable Long id) {
        return shipInfoService.obtenerNavePorId(id);
    }
    @GetMapping("/jugador/{jugadorid}/other")
    @PreAuthorize("hasAnyAuthority('CAPITAN', 'PILOTO', 'COMERCIANTE')")
    public ResponseEntity<List<Nave>> getOtherShipsInSameStar(@PathVariable Long playerId) {
        List<Nave> otherShips = shipInfoService.getOtherShipsInSameStar(playerId);
        if (!otherShips.isEmpty()) {
            return new ResponseEntity<>(otherShips, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
