package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Producto;
import com.proyecto.ComercianteEspacial.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public List<Producto> mostrarProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @PostMapping("/nuevo")
    public Producto guardarProducto(@RequestParam String nombre, @RequestParam Double factorDemanda, @RequestParam Double factorOferta, @RequestParam Double volumenUnidad) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setFactorDemanda(factorDemanda);
        producto.setFactorOferta(factorOferta);
        producto.setVolumenUnidad(volumenUnidad);
        return productoService.guardarProducto(producto);
    }
}
