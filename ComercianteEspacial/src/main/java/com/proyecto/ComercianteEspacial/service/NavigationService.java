package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NavigationService {

    @Autowired
    private EstrellaService estrellaService;

    // Método para obtener las 10 estrellas más cercanas a la posición actual de la nave
    public List<EstrellaConDistancia> getNearestStars(double naveX, double naveY, double naveZ) {
        // Obtener todas las estrellas del servicio
        Page<Estrella> estrellas = estrellaService.obtenerTodasEstrellas(0, 100);

        // Calcular la distancia entre la nave y cada estrella, y ordenarlas por distancia
        List<EstrellaConDistancia> estrellasOrdenadas = estrellas.stream()
                .map(estrella -> new EstrellaConDistancia(estrella, calcularDistancia(estrella, naveX, naveY, naveZ)))
                .sorted(Comparator.comparingDouble(EstrellaConDistancia::getDistancia))
                .collect(Collectors.toList());

        // Devolver las 10 estrellas más cercanas
        return estrellasOrdenadas.subList(0, Math.min(10, estrellasOrdenadas.size()));
    }

    // Método para calcular la distancia entre la nave y una estrella
    private double calcularDistancia(Estrella estrella, double naveX, double naveY, double naveZ) {
        // Calculamos la distancia euclidiana entre la nave y la estrella
        double distanciaX = naveX - estrella.getCoordenadaX();
        double distanciaY = naveY - estrella.getCoordenadaY();
        double distanciaZ = naveZ - estrella.getCoordenadaZ();
        return Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY + distanciaZ * distanciaZ);
    }

    // Clase interna para contener la estrella y su distancia
    public static class EstrellaConDistancia {
        private Estrella estrella;
        private double distancia;

        public EstrellaConDistancia(Estrella estrella, double distancia) {
            this.estrella = estrella;
            this.distancia = distancia;
        }

        public Estrella getEstrella() {
            return estrella;
        }

        public double getDistancia() {
            return distancia;
        }
    }
}
