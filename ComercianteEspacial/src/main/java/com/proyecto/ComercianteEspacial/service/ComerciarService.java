package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.Equipo;
import com.proyecto.ComercianteEspacial.model.Nave;
import com.proyecto.ComercianteEspacial.model.Producto;
import com.proyecto.ComercianteEspacial.repository.NaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComerciarService {

    @Autowired
    private NaveRepository naveRepository;



    public List<Producto> obtenerProductosNavesEnEstrella(Long estrellaId) {
        // Obtener todas las naves en la estrella con el ID proporcionado
        List<Nave> naves = naveRepository.findByEstrellaId(estrellaId);

        if (naves.isEmpty()) {
            System.out.println("No se encontraron naves para la estrella con ID: " + estrellaId);
        } else {
            System.out.println("Se encontraron " + naves.size() + " naves para la estrella con ID: " + estrellaId);
        }

        // Crear una lista para almacenar los productos de todas las naves
        List<Producto> productos = new ArrayList<>();

        // Iterar sobre cada nave y agregar sus productos a la lista
        for (Nave nave : naves) {
            List<Producto> productosNave = nave.getProductos();
            if (productosNave != null && !productosNave.isEmpty()) {
                productos.addAll(productosNave);
                System.out.println("Se agregaron " + productosNave.size() + " productos de la nave con ID: " + nave.getId());
            } else {
                System.out.println("La nave con ID " + nave.getId() + " no tiene productos.");
            }
        }

        return productos;
    }

    public boolean comprarProducto(Equipo equipo, Producto producto, Double cantidad) {
        // Verificar si el equipo tiene suficiente dinero para comprar el producto
        if (equipo.getDinero() < producto.getPrecioVenta() * cantidad) {
            return false; // El equipo no tiene suficiente dinero para comprar el producto
        }

        // Verificar si el precio del producto es menor o igual al dinero disponible del equipo
        if (producto.getPrecioVenta() <= equipo.getDinero()) {
            // Reducir el dinero del equipo y agregar el producto a su inventario
            equipo.setDinero(equipo.getDinero() - producto.getPrecioVenta() * cantidad);
            // Agregar lógica para agregar el producto al inventario del equipo
            return true; // La compra se realizó con éxito
        } else {
            return false; // El precio del producto es mayor que el dinero disponible del equipo
        }
    }

    public boolean venderProducto(Equipo equipo, Producto producto, Double cantidad) {
        // Obtener la nave del equipo
        Nave naveEquipo = equipo.getNave();
    
        // Obtener la lista de productos de la nave del equipo
        List<Producto> productosEnNave = naveEquipo.getProductos();
    
        // Verificar si el producto está presente en la nave del equipo y si hay suficiente cantidad para vender
        for (Producto prod : productosEnNave) {
            if (prod.equals(producto) && prod.getCantidad() >= cantidad) {
                // Calcular el monto total de la venta
                double montoVenta = producto.getPrecioCompra() * cantidad;
    
                // Aumentar el dinero del equipo y disminuir la cantidad del producto en la nave
                equipo.setDinero(equipo.getDinero() + montoVenta);
                prod.setCantidad(prod.getCantidad() - cantidad);
    
                // Si la cantidad del producto en la nave se reduce a cero, quitar el producto de la lista
                if (prod.getCantidad() == 0) {
                    productosEnNave.remove(prod);
                }
    
                // Establecer la lista actualizada de productos en la nave del equipo
                naveEquipo.setProductos(productosEnNave);
    
                return true; // La venta se realizó con éxito
            }
        }
    
        return false; // La cantidad de producto a vender no está disponible en la nave del equipo
    }
    public void agregarProductoANave(Equipo equipo, Producto producto, Double cantidad) {
        // Obtener la nave del equipo
        Nave naveEquipo = equipo.getNave();
    
        // Obtener la lista de productos de la nave del equipo
        List<Producto> productosEnNave = naveEquipo.getProductos();
    
        // Verificar si el producto ya está en la nave del equipo
        boolean productoExistente = false;
        for (Producto prod : productosEnNave) {
            if (prod.equals(producto)) {
                // Si el producto ya está en la nave, aumentar la cantidad
                prod.setCantidad(prod.getCantidad() + cantidad);
                productoExistente = true;
                break; // Salir del bucle una vez que se encuentre el producto
            }
        }
    
        // Si el producto no está en la nave, agregarlo con la cantidad especificada
        if (!productoExistente) {
            producto.setCantidad(cantidad);
            productosEnNave.add(producto);
        }
    
        // Establecer la lista actualizada de productos en la nave del equipo
        naveEquipo.setProductos(productosEnNave);
    }
}
