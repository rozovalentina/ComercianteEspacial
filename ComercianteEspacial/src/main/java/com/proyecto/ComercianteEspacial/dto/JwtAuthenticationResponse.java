package com.proyecto.ComercianteEspacial.dto;

import com.proyecto.ComercianteEspacial.model.Rol;

public class JwtAuthenticationResponse {
    private String token;
    private String nombre;
    private Rol rol;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String token, String nombre, Rol rol) {
        this.token = token;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
