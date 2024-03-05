package com.proyecto.ComercianteEspacial.model;

import jakarta.persistence.*;
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Double factorDemanda;
    private Double factorOferta;
    private Double volumenUnidad;
    private Double PrecioVenta;
    private Double PrecioCompra;

    public Producto(String string, double random) {
        //TODO Auto-generated constructor stub
    }

    public Producto() {
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

    public Double getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(Double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public Double getFactorOferta() {
        return factorOferta;
    }

    public void setFactorOferta(Double factorOferta) {
        this.factorOferta = factorOferta;
    }

    public Double getVolumenUnidad() {
        return volumenUnidad;
    }

    public void setVolumenUnidad(Double volumenUnidad) {
        this.volumenUnidad = volumenUnidad;
    }

    public Double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public Double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(Double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }


}
