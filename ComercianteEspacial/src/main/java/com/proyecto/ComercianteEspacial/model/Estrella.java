package com.proyecto.ComercianteEspacial.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Estrella {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Double coordenadaX;
    private Double coordenadaY;
    private Double coordenadaZ;

    private boolean habitada;
    @JsonManagedReference
    @OneToMany(mappedBy = "estrella", cascade = CascadeType.ALL)
    private List<Planeta> planetas;

    @OneToMany(mappedBy = "estrella")
    private List<Equipo> equiposVisitantes;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Double getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(Double coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public boolean isHabitada() {
        return habitada;
    }

    public void setHabitada(boolean habitada) {
        this.habitada = habitada;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public List<Equipo> getEquiposVisitantes() {
        return equiposVisitantes;
    }

    public void setEquiposVisitantes(List<Equipo> equiposVisitantes) {
        this.equiposVisitantes = equiposVisitantes;
    }
}