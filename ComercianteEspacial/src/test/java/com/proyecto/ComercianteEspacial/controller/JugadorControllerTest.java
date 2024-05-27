package com.proyecto.ComercianteEspacial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.proyecto.ComercianteEspacial.model.Jugador;
import com.proyecto.ComercianteEspacial.service.JugadorService;

@WebMvcTest(JugadorController.class)
public class JugadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JugadorService jugadorService;

    @Test
    public void testObtenerTodosLosJugadores() throws Exception {
        Jugador jugador1 = new Jugador();
        jugador1.setId(1L);
        jugador1.setNombre("Jugador 1");

        Jugador jugador2 = new Jugador();
        jugador2.setId(2L);
        jugador2.setNombre("Jugador 2");

        PageImpl<Jugador> page = new PageImpl<>(Arrays.asList(jugador1, jugador2));

        when(jugadorService.obtenerTodosLosJugadores(0, 10)).thenReturn(page);

        mockMvc.perform(get("/jugadores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].nombre").value("Jugador 1"))
                .andExpect(jsonPath("$.content[1].id").value(2))
                .andExpect(jsonPath("$.content[1].nombre").value("Jugador 2"));
    }

    // Aquí irían más pruebas para los otros métodos del controlador.
}
