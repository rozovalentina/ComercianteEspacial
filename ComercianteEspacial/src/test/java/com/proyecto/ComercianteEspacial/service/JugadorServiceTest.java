package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.repository.JugadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class JugadorServiceTest {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Test
    void testGuardarJugador() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Nuevo Jugador");
        jugador.setpassword("password123");

        Jugador result = jugadorService.guardarJugador(jugador);

        assertNotNull(result);
        assertEquals("Nuevo Jugador", result.getNombre());
    }

    @Test
    void testObtenerJugadorPorId() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Jugador Prueba");
        jugador.setpassword("password123");

        Jugador guardado = jugadorService.guardarJugador(jugador);

        Jugador result = jugadorService.obtenerJugadorPorId(guardado.getId());

        assertNotNull(result);
        assertEquals("Jugador Prueba", result.getNombre());
    }

    @Test
    void testEliminarJugadorPorId() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Jugador Eliminar");
        jugador.setpassword("password123");

        Jugador guardado = jugadorService.guardarJugador(jugador);

        jugadorService.eliminarJugadorPorId(guardado.getId());

        Jugador result = jugadorService.obtenerJugadorPorId(guardado.getId());

        assertNull(result);
    }

    @Test
    void testActualizarJugador() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Jugador Actualizar");
        jugador.setpassword("password123");

        Jugador guardado = jugadorService.guardarJugador(jugador);

        Jugador actualizado = new Jugador();
        actualizado.setNombre("Jugador Actualizado");
        actualizado.setpassword("newpassword123");

        Jugador result = jugadorService.actualizarJugador(guardado.getId(), actualizado);

        assertNotNull(result);
        assertEquals("Jugador Actualizado", result.getNombre());
        assertEquals("newpassword123", result.getPassword());
    }

    @Test
    void testAuthenticate() {
        Jugador jugador = new Jugador();
        jugador.setNombre("JugadorAuth");
        jugador.setpassword("password123");

        jugadorService.guardarJugador(jugador);

        Jugador result = jugadorService.authenticate("JugadorAuth", "password123");

        assertNotNull(result);
        assertEquals("JugadorAuth", result.getNombre());
    }
}
