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

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.service.EquipoService;

@WebMvcTest(EquipoController.class)
public class EquipoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipoService equipoService;

    @Test
    public void testMostrarEquipos() throws Exception {
        Equipo equipo1 = new Equipo();
        equipo1.setId(1L);
        equipo1.setNombre("Equipo 1");

        Equipo equipo2 = new Equipo();
        equipo2.setId(2L);
        equipo2.setNombre("Equipo 2");

        PageImpl<Equipo> page = new PageImpl<>(Arrays.asList(equipo1, equipo2));

        when(equipoService.obtenerTodosLosEquipos(0, 10)).thenReturn(page);

        mockMvc.perform(get("/equipos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].nombre").value("Equipo 1"))
                .andExpect(jsonPath("$.content[1].id").value(2))
                .andExpect(jsonPath("$.content[1].nombre").value("Equipo 2"));
    }

    // Aquí irían más pruebas para los otros métodos del controlador.
}
