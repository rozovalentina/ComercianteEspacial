package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String contraseña;
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "nave_id")
    private Nave nave;


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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Nave getNave() {
        return nave;
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
