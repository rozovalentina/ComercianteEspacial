package com.proyecto.ComercianteEspacial.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Double cargaMaxima;
    private Double velocidadMaxima;
    private Double naveX;
    private Double naveY;
    private Double naveZ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estrella_id")
    private Estrella estrella; // Nueva relación con Estrella

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tipo_nave_id")
    private TipoNave tipoNave;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToOne(mappedBy = "nave")
    @JsonIgnore
    private Jugador jugador;

    @JsonIgnore
    @OneToMany(mappedBy = "nave", cascade = CascadeType.PERSIST)
    private List<Producto> productos = new ArrayList<>(); // Relación con los productos

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

    public Double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(Double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(Double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Double getNaveX() {
        return naveX;
    }

    public void setNaveX(Double naveX) {
        this.naveX = naveX;
    }

    public Double getNaveY() {
        return naveY;
    }

    public void setNaveY(Double naveY) {
        this.naveY = naveY;
    }

    public Double getNaveZ() {
        return naveZ;
    }

    public void setNaveZ(Double naveZ) {
        this.naveZ = naveZ;
    }

    public TipoNave getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(TipoNave tipoNave) {
        this.tipoNave = tipoNave;
    }

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    // Método para agregar un producto a la lista de productos de la nave
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }
}
