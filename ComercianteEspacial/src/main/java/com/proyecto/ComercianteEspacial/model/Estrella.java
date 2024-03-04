package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Estrella {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    private Punto3D coordenadas;

    private boolean habitada;

    @OneToMany(mappedBy = "estrella", cascade = CascadeType.ALL)
    private List<Planeta> planetas;

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

    public Punto3D getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Punto3D coordenadas) {
        this.coordenadas = coordenadas;
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
}
