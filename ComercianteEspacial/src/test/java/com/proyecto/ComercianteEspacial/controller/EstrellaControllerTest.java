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

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.service.EstrellaService;

@WebMvcTest(EstrellaController.class)
public class EstrellaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstrellaService estrellaService;

    @Test
    public void testMostrarListaEstrellas() throws Exception {
        Estrella estrella1 = new Estrella();
        estrella1.setId(1L);
        estrella1.setNombre("Estrella 1");

        Estrella estrella2 = new Estrella();
        estrella2.setId(2L);
        estrella2.setNombre("Estrella 2");

        PageImpl<Estrella> page = new PageImpl<>(Arrays.asList(estrella1, estrella2));

        when(estrellaService.obtenerTodasEstrellas(0, 10)).thenReturn(page);

        mockMvc.perform(get("/estrellas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].nombre").value("Estrella 1"))
                .andExpect(jsonPath("$.content[1].id").value(2))
                .andExpect(jsonPath("$.content[1].nombre").value("Estrella 2"));
    }

    // Aquí irían más pruebas para los otros métodos del controlador.
}
