package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String contraseña;

  
    @ManyToMany
    @JoinTable(
            name = "jugador_estrella",
            joinColumns = @JoinColumn(name = "jugador_id"),
            inverseJoinColumns = @JoinColumn(name = "estrella_id")
    )
    private List<Estrella> estrellasVisitadas;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "nave_id")
    private Equipo nave;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

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
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Estrella> getEstrellasVisitadas() {
        return estrellasVisitadas;
    }

    public void setEstrellasVisitadas(List<Estrella> estrellasVisitadas) {
        this.estrellasVisitadas = estrellasVisitadas;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Equipo getNave() {
        return nave;
    }

    public void setNave(Equipo nave) {
        this.nave = nave;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
