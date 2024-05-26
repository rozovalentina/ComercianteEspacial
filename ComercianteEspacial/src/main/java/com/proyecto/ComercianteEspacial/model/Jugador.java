package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String contrasena;

  
    @ManyToMany
    @JoinTable(
            name = "jugador_estrella",
            joinColumns = @JoinColumn(name = "jugador_id"),
            inverseJoinColumns = @JoinColumn(name = "estrella_id")
    )
    private List<Estrella> estrellasVisitadas;


    @JsonIgnore // Ignorar esta propiedad al serializar/deserializar
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToOne
    @JoinColumn(name = "nave_id")
    @JsonIgnore
    private Nave nave;

    public Jugador() {
        // Constructor vacío necesario para JPA
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String string, Equipo equipo2) {
        //TODO Auto-generated constructor stub
    }

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

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public List<Estrella> getEstrellasVisitadas() {
        return estrellasVisitadas;
    }

    public void setEstrellasVisitadas(List<Estrella> estrellasVisitadas) {
        this.estrellasVisitadas = estrellasVisitadas;
    }

    public Nave getNave() {
        return  nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
