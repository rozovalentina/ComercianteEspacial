package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Estrella;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceTravelService {

    @Autowired
    private EstrellaService estrellaService;

    // Método para iniciar un viaje interestelar hacia la estrella seleccionada
    public void initiateSpaceTravel(Long starId) {
        // Implementar la lógica para iniciar un viaje interestelar hacia la estrella seleccionada
        // Por simplicidad, imprimimos un mensaje indicando que el viaje se ha iniciado
        System.out.println("Viaje iniciado hacia la estrella con ID: " + starId);
    }

    // Método para calcular el tiempo de viaje estimado entre las dos estrellas
    public double getTravelTime(Long sourceStarId, Long destinationStarId, double shipSpeed) {
        // Obtener las estrellas de origen y destino
        Estrella sourceStar = estrellaService.obtenerEstrellaPorId(sourceStarId);
        Estrella destinationStar = estrellaService.obtenerEstrellaPorId(destinationStarId);

        // Calcular la distancia entre las estrellas utilizando sus coordenadas
        double distance = calculateDistance(sourceStar, destinationStar);

        // Calcular el tiempo de viaje utilizando la fórmula de velocidad: tiempo = distancia / velocidad
        return distance / shipSpeed;
    }

    // Método para calcular la distancia entre dos estrellas utilizando sus coordenadas
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