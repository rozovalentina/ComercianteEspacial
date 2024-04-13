package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "tipo_nave_id")
    private TipoNave tipoNave;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
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

    public Double getnaveX() {
        return naveX;
    }

    public void setnaveX(Double naveX) {
        this.naveX = naveX;
    }

    public Double getnaveY() {
        return naveY;
    }

    public void setCoordenadaY(Double naveY) {
        this.naveY = naveY;
    }

    public Double getnaveZ() {
        return naveZ;
    }

    public void setCoordenadaZ(Double naveZ) {
        this.naveZ = naveZ;
    }


    public TipoNave getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(TipoNave tipoNave) {
        this.tipoNave = tipoNave;
    }



}



























