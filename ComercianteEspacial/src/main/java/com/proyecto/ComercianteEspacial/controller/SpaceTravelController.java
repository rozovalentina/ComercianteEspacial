package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.service.SpaceTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/viaje")
public class SpaceTravelController {

    @Autowired
    private SpaceTravelService spaceTravelService;

    @PostMapping("/iniciar")
    @PreAuthorize("hasAnyAuthority('CAPITAN', 'PILOTO', 'COMERCIANTE')")
    public Nave iniciarViaje(@RequestParam Long naveId, @RequestParam Long estrellaDestinoId) {
        return spaceTravelService.iniciarViajeInterestelar(naveId, estrellaDestinoId);
    }
}
