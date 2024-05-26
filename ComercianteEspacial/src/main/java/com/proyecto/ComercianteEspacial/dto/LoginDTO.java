package com.proyecto.ComercianteEspacial.dto;

public class LoginDTO{
  private String nombre;
  private String password;

  public LoginDTO(){
  }

  public LoginDTO(String nombre, String password){
    this.nombre = nombre;
    this.password = password;
  }

  public String getNombre(){
    return this.nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getpassword(){
    return this.password;
  }

  public void setContreseña(String password){
    this.password = password;
  }
}
