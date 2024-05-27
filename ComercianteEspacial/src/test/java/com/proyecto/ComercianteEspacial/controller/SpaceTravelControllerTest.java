package com.proyecto.ComercianteEspacial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.proyecto.ComercianteEspacial.service.SpaceTravelService;

@WebMvcTest(SpaceTravelController.class)
public class SpaceTravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpaceTravelService spaceTravelService;

    @Test
    public void testInitiateSpaceTravel() throws Exception {
        doNothing().when(spaceTravelService).initiateSpaceTravel(1L);

        mockMvc.perform(post("/viaje/iniciar")
                .param("starId", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Aquí irían más pruebas para los otros métodos del controlador.
}
