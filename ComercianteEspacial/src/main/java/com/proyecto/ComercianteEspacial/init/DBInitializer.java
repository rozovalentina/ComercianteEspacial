package com.proyecto.ComercianteEspacial.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.proyecto.ComercianteEspacial.model.*;
import com.proyecto.ComercianteEspacial.repository.*;

import java.util.Random;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public void run(String... args) throws Exception {
        generarEstrellas();
        generarJugadores();
        generarTiposNaves();
        generarEspecificacionesProductos();
    }

    public void generarEstrellas() {
        Random random = new Random();
        int totalEstrellas = 40000;
        int totalPlanetas = totalEstrellas / 100; // 1% de estrellas con planetas

        
            for (int i = 0; i < totalEstrellas; i++) {
                double coordenadaX = random.nextDouble() * 300;
                double coordenadaY = random.nextDouble() * 300;
                double coordenadaZ = random.nextDouble() * 300;
                Estrella estrella = new Estrella();
                estrella.setNombre("Estrella " + i);
                estrella.setCoordenadaX(coordenadaX); // Utilizar coordenadaX aquí
                estrella.setCoordenadaY(coordenadaY);
                estrella.setCoordenadaZ(coordenadaZ);
                estrellaRepository.save(estrella);

            // Generar planetas para algunas estrellas
            if (i < totalPlanetas) {
                int numPlanetas = random.nextInt(3) + 1; // Entre 1 y 3 planetas
                for (int j = 0; j < numPlanetas; j++) {
                    Planeta planeta = new Planeta();
                    planeta.setNombre("Planeta " + j + " de Estrella " + i);
                    planeta.setEstrella(estrella);
                    // Configurar otras propiedades del planeta si es necesario
                    planetaRepository.save(planeta);
                }
            }
        }
    }

    public void generarJugadores() {
        int totalEquipos = 10;
        int jugadoresPorEquipo = 10;

        for (int i = 0; i < totalEquipos; i++) {
            Equipo equipo = new Equipo();
            equipo.setNombre("Equipo " + i);
            equipo.setDinero(1000.0); // Establecer una cantidad inicial de dinero
            equipoRepository.save(equipo);

            for (int j = 0; j < jugadoresPorEquipo; j++) {
                Jugador jugador = new Jugador();
                jugador.setNombre("Jugador " + (i * jugadoresPorEquipo + j));
                jugador.setContraseña(generarContraseñaAleatoria()); // Generar una contraseña aleatoria si es necesario
                jugador.setEquipo(equipo);
                jugadorRepository.save(jugador);
            }
        }
    }

    public void generarEspecificacionesProductos() {
        int totalEspecificaciones = 500;

        for (int i = 0; i < totalEspecificaciones; i++) {
            Producto especificacion = new Producto("Producto " + i, Math.random());
            productoRepository.save(especificacion);
        }
    }

    public void generarTiposNaves() {
        int totalTiposNaves = 20;

        for (int i = 0; i < totalTiposNaves; i++) {
            TipoNave tipoNave = new TipoNave("Tipo de Nave " + i);
            tipoNaveRepository.save(tipoNave);
        }
    }

    // Métodos adicionales para generar datos simulados (contraseña aleatoria y rol aleatorio)
    private String generarContraseñaAleatoria() {
        // Lógica para generar una contraseña aleatoria
        return "contraseñaAleatoria"; // Cambia esto según tus necesidades
    }
}

 