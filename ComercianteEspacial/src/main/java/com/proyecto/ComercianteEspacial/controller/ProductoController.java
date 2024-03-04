package com.proyecto.ComercianteEspacial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ComercianteEspacial.model.Producto;
import com.proyecto.ComercianteEspacial.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "lista_productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevoProducto() {
        return "formulario_producto";
    }

    @PostMapping("/productos/nuevo")
    public String guardarProducto(@RequestParam String nombre, @RequestParam Double factorDemanda, @RequestParam Double factorOferta, @RequestParam Double volumenUnidad) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setFactorDemanda(factorDemanda);
        producto.setFactorOferta(factorOferta);
        producto.setVolumenUnidad(volumenUnidad);
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    // Otros métodos del controlador según sea necesario para editar, eliminar y mostrar detalles de productos
}
