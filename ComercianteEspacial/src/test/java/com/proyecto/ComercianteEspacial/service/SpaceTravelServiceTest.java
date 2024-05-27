package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpaceTravelServiceTest {

    @Autowired
    private SpaceTravelService spaceTravelService;

    @Autowired
    private EstrellaService estrellaService;

    @Test
    void testInitiateSpaceTravel() {
        Estrella estrella = new Estrella();
        estrella.setNombre("Estrella Viaje");
        estrella.setCoordenadaX((double) 10);
        estrella.setCoordenadaY((double) 20);
        estrella.setCoordenadaZ((double) 30);
        Estrella guardada = estrellaService.guardarEstrella(estrella);

        spaceTravelService.initiateSpaceTravel(guardada.getId());
        // Aquí simplemente imprimimos un mensaje, no hay mucho que probar a nivel unitario
    }

    @Test
    void testGetTravelTime() {
        Estrella source = new Estrella();
        source.setNombre("Estrella Origen");
        source.setCoordenadaX((double) 0);
        source.setCoordenadaY((double) 0);
        source.setCoordenadaZ((double) 0);
        Estrella destino = new Estrella();
        destino.setNombre("Estrella Destino");
        destino.setCoordenadaX((double) 10);
        destino.setCoordenadaY((double) 20);
        destino.setCoordenadaZ((double) 30);
        Estrella guardadaSource = estrellaService.guardarEstrella(source);
        Estrella guardadaDestino = estrellaService.guardarEstrella(destino);

        double travelTime = spaceTravelService.getTravelTime(guardadaSource.getId(), guardadaDestino.getId(), 10);

        assertEquals(Math.sqrt(1400) / 10, travelTime);
    }
}
