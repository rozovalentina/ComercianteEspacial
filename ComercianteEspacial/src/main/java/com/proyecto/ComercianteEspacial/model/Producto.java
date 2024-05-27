package com.proyecto.ComercianteEspacial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Double precioVenta; // Cambiado a camelCase
    private Double precioCompra; // Cambiado a camelCase
    private Double cantidad;
    
    @JsonIgnore
    @ManyToOne // Agregar relación Many-to-One con Nave
    private Nave nave;
    
    public Producto(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public Producto() {
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
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }
}
