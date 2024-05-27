package com.proyecto.ComercianteEspacial.controller;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.model.Producto;
import com.proyecto.ComercianteEspacial.service.ComerciarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comercializar")
public class ComerciarController {

    @Autowired
    private ComerciarService comercializarService;

    @GetMapping("/productos/{estrellaId}")
    @PreAuthorize("hasAnyAuthority('COMERCIANTE')")
    public ResponseEntity<List<Producto>> obtenerProductosNavesEnEstrella(@PathVariable Long estrellaId) {
        System.out.println("Recibida solicitud para obtener productos de la estrella con ID: " + estrellaId);
        List<Producto> productos = comercializarService.obtenerProductosNavesEnEstrella(estrellaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping("/comprar")
    public ResponseEntity<String> comprarProducto(@RequestBody CompraRequest compraRequest) {
        boolean compraExitosa = comercializarService.comprarProducto(compraRequest.getEquipo(), compraRequest.getProducto(), compraRequest.getCantidad());
        if (compraExitosa) {
            return new ResponseEntity<>("La compra se realizó con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo realizar la compra debido a fondos insuficientes", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/vender")
    public ResponseEntity<String> venderProducto(@RequestBody VentaRequest ventaRequest) {
        boolean ventaExitosa = comercializarService.venderProducto(ventaRequest.getEquipo(), ventaRequest.getProducto(), ventaRequest.getCantidad());
        if (ventaExitosa) {
            return new ResponseEntity<>("La venta se realizó con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo realizar la venta debido a productos insuficientes", HttpStatus.BAD_REQUEST);
        }
    }

    // Clase para manejar el cuerpo de la solicitud de compra
    static class CompraRequest {
        private Equipo equipo;
        private Producto producto;
        private Double cantidad;

        // Getters y setters
        public Equipo getEquipo() {
            return equipo;
        }

        public void setEquipo(Equipo equipo) {
            this.equipo = equipo;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public Double getCantidad() {
            return cantidad;
        }

        public void setCantidad(Double cantidad) {
            this.cantidad = cantidad;
        }
    }

    // Clase para manejar el cuerpo de la solicitud de venta
    static class VentaRequest {
        private Equipo equipo;
        private Producto producto;
        private Double cantidad;

        // Getters y setters
        public Equipo getEquipo() {
            return equipo;
        }

        public void setEquipo(Equipo equipo) {
            this.equipo = equipo;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public Double getCantidad() {
            return cantidad;
        }

        public void setCantidad(Double cantidad) {
            this.cantidad = cantidad;
        }
    }
}
