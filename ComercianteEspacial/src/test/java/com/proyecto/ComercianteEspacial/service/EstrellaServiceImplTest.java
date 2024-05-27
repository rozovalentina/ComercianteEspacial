package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.repository.EstrellaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class EstrellaServiceImplTest {

    @Autowired
    private EstrellaServiceImpl estrellaService;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Test
    void testGuardarEstrella() {
        Estrella estrella = new Estrella();
        estrella.setNombre("Nueva Estrella");
        estrella.setCoordenadaX(10.0);
        estrella.setCoordenadaY(20.0);
        estrella.setCoordenadaZ(30.0);
        estrella.setHabitada(true);

        Estrella result = estrellaService.guardarEstrella(estrella);

        assertNotNull(result);
        assertEquals("Nueva Estrella", result.getNombre());
    }

    @Test
    void testObtenerEstrellaPorId() {
        Estrella estrella = new Estrella();
        estrella.setNombre("Estrella Prueba");
        estrella.setCoordenadaX(10.0);
        estrella.setCoordenadaY(20.0);
        estrella.setCoordenadaZ(30.0);
        estrella.setHabitada(true);

        Estrella guardada = estrellaService.guardarEstrella(estrella);

        Estrella result = estrellaService.obtenerEstrellaPorId(guardada.getId());

        assertNotNull(result);
        assertEquals("Estrella Prueba", result.getNombre());
    }

    @Test
    void testObtenerTodasEstrellas() {
        Estrella estrella1 = new Estrella();
        estrella1.setNombre("Estrella 1");
        estrella1.setCoordenadaX(10.0);
        estrella1.setCoordenadaY(20.0);
        estrella1.setCoordenadaZ(30.0);
        estrella1.setHabitada(true);

        Estrella estrella2 = new Estrella();
        estrella2.setNombre("Estrella 2");
        estrella2.setCoordenadaX(40.0);
        estrella2.setCoordenadaY(50.0);
        estrella2.setCoordenadaZ(60.0);
        estrella2.setHabitada(false);

        estrellaService.guardarEstrella(estrella1);
        estrellaService.guardarEstrella(estrella2);

        List<Estrella> result = estrellaService.obtenerTodasEstrellas(0, 10).getContent();

        assertEquals(2, result.size());
    }

    @Test
    void testActualizarEstrella() {
        Estrella estrella = new Estrella();
        estrella.setNombre("Estrella Actualizar");
        estrella.setCoordenadaX(10.0);
        estrella.setCoordenadaY(20.0);
        estrella.setCoordenadaZ(30.0);
        estrella.setHabitada(true);

        Estrella guardada = estrellaService.guardarEstrella(estrella);

        Estrella actualizada = new Estrella();
        actualizada.setNombre("Estrella Actualizada");
        actualizada.setCoordenadaX(100.0);
        actualizada.setCoordenadaY(200.0);
        actualizada.setCoordenadaZ(300.0);
        actualizada.setHabitada(false);

        Estrella result = estrellaService.actualizarEstrella(guardada.getId(), actualizada);

        assertNotNull(result);
        assertEquals("Estrella Actualizada", result.getNombre());
        assertEquals(100.0, result.getCoordenadaX());
        assertEquals(200.0, result.getCoordenadaY());
        assertEquals(300.0, result.getCoordenadaZ());
        assertFalse(result.isHabitada());
    }

    @Test
    void testEliminarEstrella() {
        Estrella estrella = new Estrella();
        estrella.setNombre("Estrella Eliminar");
        estrella.setCoordenadaX(10.0);
        estrella.setCoordenadaY(20.0);
        estrella.setCoordenadaZ(30.0);
        estrella.setHabitada(true);

        Estrella guardada = estrellaService.guardarEstrella(estrella);

        estrellaService.eliminarEstrella(guardada.getId());

        Estrella result = estrellaService.obtenerEstrellaPorId(guardada.getId());

        assertNull(result);
    }
}
