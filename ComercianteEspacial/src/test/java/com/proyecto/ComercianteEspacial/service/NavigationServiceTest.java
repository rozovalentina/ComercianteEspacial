package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class NavigationServiceTest {

    @Autowired
    private NavigationService navigationService;

    @Autowired
    private EstrellaService estrellaService;

    @Test
    void testGetNearestStars() {
        for (int i = 1; i <= 15; i++) {
            Estrella estrella = new Estrella();
            estrella.setNombre("Estrella " + i);
            estrella.setCoordenadaX((double) (i * 10));
            estrella.setCoordenadaY((double) (i * 20));
            estrella.setCoordenadaZ((double) (i * 30));
            estrellaService.guardarEstrella(estrella);
        }

        List<NavigationService.EstrellaConDistancia> nearestStars = navigationService.getNearestStars(0, 0, 0);

        assertEquals(10, nearestStars.size());
        assertEquals("Estrella 1", nearestStars.get(0).getEstrella().getNombre());
    }
}
