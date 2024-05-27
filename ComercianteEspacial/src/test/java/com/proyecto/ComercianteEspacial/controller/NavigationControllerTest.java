package com.proyecto.ComercianteEspacial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.service.NavigationService;

@WebMvcTest(NavigationController.class)
public class NavigationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NavigationService navigationService;

    @Test
    public void testGetNearestStars() throws Exception {
        NavigationService.EstrellaConDistancia estrella1 = new NavigationService.EstrellaConDistancia(new Estrella(), 10.5);
        NavigationService.EstrellaConDistancia estrella2 = new NavigationService.EstrellaConDistancia(new Estrella(), 15.7);

        when(navigationService.getNearestStars(0.0, 0.0, 0.0)).thenReturn(Arrays.asList(estrella1, estrella2));

        mockMvc.perform(get("/estrellas/cercanas")
                .param("naveX", "0.0")
                .param("naveY", "0.0")
                .param("naveZ", "0.0")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].distancia").value(10.5))
                .andExpect(jsonPath("$[1].distancia").value(15.7));
    }

    // Aquí irían más pruebas para los otros métodos del controlador.
}
