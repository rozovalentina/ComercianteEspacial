package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.repository.EquipoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class EquipoServiceTest {

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EquipoRepository equipoRepository;

    @Test
    void testSaveEquipo() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Nuevo Equipo");
        equipo.setDinero((double) 1000);

        Equipo result = equipoService.saveEquipo(equipo);

        assertNotNull(result);
        assertEquals("Nuevo Equipo", result.getNombre());
    }

    @Test
    void testGetEquipoById() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo Prueba");
        equipo.setDinero((double) 1000);

        Equipo guardado = equipoService.saveEquipo(equipo);

        Equipo result = equipoService.getEquipoById(guardado.getId());

        assertNotNull(result);
        assertEquals("Equipo Prueba", result.getNombre());
    }

    @Test
    void testDeleteEquipo() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo Eliminar");
        equipo.setDinero((double) 1000);

        Equipo guardado = equipoService.saveEquipo(equipo);

        equipoService.deleteEquipo(guardado.getId());

        Equipo result = equipoService.getEquipoById(guardado.getId());

        assertNull(result);
    }

    @Test
    void testUpdateEquipo() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo Actualizar");
        equipo.setDinero((double) 1000);

        Equipo guardado = equipoService.saveEquipo(equipo);

        Equipo actualizado = new Equipo();
        actualizado.setNombre("Equipo Actualizado");
        actualizado.setDinero((double) 2000);

        Equipo result = equipoService.updateEquipo(guardado.getId(), actualizado);

        assertNotNull(result);
        assertEquals("Equipo Actualizado", result.getNombre());
        assertEquals(2000, result.getDinero());
    }
}
