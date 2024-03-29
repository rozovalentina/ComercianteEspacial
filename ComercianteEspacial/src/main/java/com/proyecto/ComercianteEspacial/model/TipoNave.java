package com.proyecto.ComercianteEspacial.model;
import jakarta.persistence.*;

@Entity
public class TipoNave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    

    public TipoNave(String string) {
        this.nombre = string;
    }

    public TipoNave() {
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


}

