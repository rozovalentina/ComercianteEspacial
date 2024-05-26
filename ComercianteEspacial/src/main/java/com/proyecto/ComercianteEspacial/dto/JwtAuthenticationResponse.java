package com.proyecto.ComercianteEspacial.dto;

import com.proyecto.ComercianteEspacial.model.Role;

public class JwtAuthenticationResponse {
    private String token;
    private String nombre;
    private Role rol;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String token, String nombre, Role rol) {
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

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
