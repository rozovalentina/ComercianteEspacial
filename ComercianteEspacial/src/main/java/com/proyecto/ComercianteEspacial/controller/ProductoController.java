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
    public String guardarProducto(@RequestParam String nombre, @RequestParam Double factorDemanda, @RequestParam Double factorOferta, @RequestParam Double volumenUnidad, @RequestParam Double PrecioVenta, @RequestParam Double PrecioCompra) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setFactorDemanda(factorDemanda);
        producto.setFactorOferta(factorOferta);
        producto.setVolumenUnidad(volumenUnidad);
        producto.setPrecioCompra(PrecioCompra);
        producto.setPrecioVenta(PrecioVenta);
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String mostrarDetallesProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "detalles_producto";
    }

    @GetMapping("/productos/{id}/editar")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "formulario_editar_producto";
    }

    @PostMapping("/productos/{id}/editar")
    public String editarProducto(@PathVariable Long id, @RequestParam String nombre) {
        Producto producto = productoService.obtenerProductoPorId(id);
        producto.setNombre(nombre);
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProductoPorId(id);
        return "redirect:/productos";
    }

    

    // Otros métodos del controlador según sea necesario para editar, eliminar y mostrar detalles de productos
}
