package com.proyecto.ComercianteEspacial.dto;

import com.proyecto.ComercianteEspacial.model.Rol;

public class UserRegistrationDTO {
    private String nombre;
    private String password;
    private Rol rol;
    private Long idNave;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String nombre, String password, Rol rol, Long idnave) {
        this.nombre=nombre;
        this.password = password;
        this.rol = rol;
        this.idNave=idnave;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdNave() {
        return idNave;
    }

    public void setIdNave(Long idNave) {
        this.idNave = idNave;
    }

    

}
