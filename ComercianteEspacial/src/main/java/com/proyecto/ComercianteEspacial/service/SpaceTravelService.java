package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.repository.EstrellaRepository;
import com.proyecto.ComercianteEspacial.repository.NaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceTravelService {

    @Autowired
    private EstrellaServiceImpl estrellaService;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    public Nave iniciarViajeInterestelar(Long naveId, Long estrellaDestinoId) {
        Nave nave = naveRepository.findById(naveId)
                .orElseThrow(() -> new RuntimeException("Nave no encontrada"));

        Estrella estrellaDestino = estrellaRepository.findById(estrellaDestinoId)
                .orElseThrow(() -> new RuntimeException("Estrella destino no encontrada"));

        nave.setNaveX(estrellaDestino.getCoordenadaX());
        nave.setNaveY(estrellaDestino.getCoordenadaY());
        nave.setNaveZ(estrellaDestino.getCoordenadaZ());

        return naveRepository.save(nave);
    }

    // Método para calcular el tiempo de viaje estimado entre las dos estrellas
    public double getTravelTime(Long sourceStarId, Long destinationStarId, double shipSpeed) {
        // Obtener las estrellas de origen y destino
        Estrella sourceStar = estrellaService.obtenerEstrellaPorId(sourceStarId);
        Estrella destinationStar = estrellaService.obtenerEstrellaPorId(destinationStarId);

        // Calcular la distancia entre las estrellas utilizando sus coordenadas
        double distance = calculateDistance(sourceStar, destinationStar);

        // Calcular el tiempo de viaje utilizando la fórmula de velocidad: tiempo =
        // distancia / velocidad
        return distance / shipSpeed;
    }

    // Método para calcular la distancia entre dos estrellas utilizando sus
    // coordenadas
    private double calculateDistance(Estrella sourceStar, Estrella destinationStar) {
        // Obtener las coordenadas de las estrellas
        double x1 = sourceStar.getCoordenadaX();
        double y1 = sourceStar.getCoordenadaY();
        double z1 = sourceStar.getCoordenadaZ();

        double x2 = destinationStar.getCoordenadaX();
        double y2 = destinationStar.getCoordenadaY();
        double z2 = destinationStar.getCoordenadaZ();

        // Calcular la distancia utilizando la fórmula euclidiana en tres dimensiones
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        return distance;
    }
}