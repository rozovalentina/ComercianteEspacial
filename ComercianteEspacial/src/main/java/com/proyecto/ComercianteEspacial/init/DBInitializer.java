package com.proyecto.ComercianteEspacial.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.proyecto.ComercianteEspacial.model.*;
import com.proyecto.ComercianteEspacial.repository.*;
import com.proyecto.ComercianteEspacial.repository.NaveRepository;


import java.util.List;
import java.util.Random;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private RolRepository RolRepository;

    @Override
    public void run(String... args) throws Exception {
        crearRol();
        generarEstrellas();
        generarJugadores();
        generarTiposNaves();
        generarEspecificacionesProductos();
    }

    public void generarEstrellas() {
        Random random = new Random();
        int totalEstrellas = 40000;
        int totalPlanetas = totalEstrellas / 100; // 1% de estrellas con planetas

        for (int i = 0; i < totalEstrellas; i++) {
            double coordenadaX = random.nextDouble() * 300;
            double coordenadaY = random.nextDouble() * 300;
            double coordenadaZ = random.nextDouble() * 300;
            Estrella estrella = new Estrella();
            estrella.setNombre("Estrella " + i);
            estrella.setCoordenadaX(coordenadaX); // Utilizar coordenadaX aquí
            estrella.setCoordenadaY(coordenadaY);
            estrella.setCoordenadaZ(coordenadaZ);
            estrellaRepository.save(estrella);

            // Generar planetas para algunas estrellas
            if (i < totalPlanetas) {
                int numPlanetas = random.nextInt(3) + 1; // Entre 1 y 3 planetas
                for (int j = 0; j < numPlanetas; j++) {
                    Planeta planeta = new Planeta();
                    planeta.setNombre("Planeta " + j + " de Estrella " + i);
                    planeta.setEstrella(estrella);
                    // Configurar otras propiedades del planeta si es necesario
                    planetaRepository.save(planeta);
                }
            }
        }
    }

    public void generarJugadores() {
        int totalEquipos = 10;
        int jugadoresPorEquipo = 10;
    
        List<TipoNave> tiposNaves = tipoNaveRepository.findAll();
        List<Rol> roles = RolRepository.findAll();
        List<Estrella> estrellas = estrellaRepository.findAll();
    
        Random random = new Random();
    
        for (int i = 0; i < totalEquipos; i++) {
            Equipo equipo = new Equipo();
            equipo.setNombre("Equipo " + i);
            equipo.setDinero(1000.0);
            equipoRepository.save(equipo);
    
            for (int j = 0; j < jugadoresPorEquipo; j++) {
                Jugador jugador = new Jugador();
                jugador.setNombre("Jugador " + (i * jugadoresPorEquipo + j));
                jugador.setContraseña(generarContraseñaAleatoria());
                jugador.setEquipo(equipo);
    
                // Asignar un rol aleatorio al jugador si la lista de roles no está vacía
                if (!roles.isEmpty()) {
                    int randomIndexRol = random.nextInt(roles.size());
                    Rol rolAleatorio = roles.get(randomIndexRol);
                    jugador.setRol(rolAleatorio);
                } else {
                    // Haz algo si la lista de roles está vacía (por ejemplo, asignar un rol por defecto)
                    // Aquí puedes asignar un rol por defecto o lanzar una excepción según tu lógica de negocio
                }
    
                // Asignar un tipo de nave aleatorio si la lista de tipos de naves no está vacía
                if (!tiposNaves.isEmpty()) {
                    int randomIndexTipoNave = random.nextInt(tiposNaves.size());
                    TipoNave tipoNaveAleatorio = tiposNaves.get(randomIndexTipoNave);
                    Nave nave = new Nave();
                    nave.setNombre("Nave de Jugador " + (i * jugadoresPorEquipo + j));
                    nave.setCargaMaxima(100.0);
                    nave.setTipoNave(tipoNaveAleatorio);
                    
                    // Asignar una estrella aleatoria si la lista de estrellas no está vacía
                    if (!estrellas.isEmpty()) {
                        int randomIndexEstrella = random.nextInt(estrellas.size());
                        Estrella estrellaAleatoria = estrellas.get(randomIndexEstrella);
                        nave.setEstrella(estrellaAleatoria);
                    }
                    
                    naveRepository.save(nave);
                    jugador.setNave(nave);
    
                    // Asignar productos a la nave
                    asignarProductosANave(nave);
                }
        
                jugadorRepository.save(jugador);
            }
        }
    }
    
    

    public void generarEspecificacionesProductos() {
        int totalEspecificaciones = 500;

        for (int i = 0; i < totalEspecificaciones; i++) {
            Producto especificacion = new Producto("Producto " + i, Math.random());
            especificacion.setNombre(GeneradorNombresProductos.generarNombre());
            especificacion.setFactorDemanda(generarFactorDemanda());
            especificacion.setFactorOferta(generarFactorOferta());
            especificacion.setVolumenUnidad(Math.random());
            especificacion.setPrecioVenta(calcularPrecioVenta(especificacion));
            especificacion.setPrecioCompra(calcularPrecioCompra(especificacion));
            productoRepository.save(especificacion);
        }
    }

    private double calcularPrecioVenta(Producto producto) {
        double stock = generarStock();

        return producto.getFactorDemanda() / (1 + stock);
    }

    private double calcularPrecioCompra(Producto producto) {
        double stock = generarStock();

        return producto.getFactorOferta() / (1 + stock);
    }

    private double generarFactorDemanda() {
        return Math.random() * 1000000;
    }

    private double generarFactorOferta() {
        return Math.random() * 1000000;
    }

    private double generarStock() {
        return Math.random() * 1000000;
    }

    public class GeneradorNombresProductos {
        private static final String[] palabras1 = { "Agua", "Hierro", "Comida", "Energía", "Oxígeno", "Metales",
                "Minerales", "Gas", "Tecnología", "Armas" };
        private static final String[] palabras2 = { "Espacial", "Galáctico", "Estelar", "Planetario", "Interestelar",
                "Cosmos", "Universal", "Intergaláctico" };

        public static String generarNombre() {
            Random rand = new Random();
            int index1 = rand.nextInt(palabras1.length);
            int index2 = rand.nextInt(palabras2.length);

            return palabras1[index1] + " " + palabras2[index2];
        }
    }

    public void generarTiposNaves() {
        int totalTiposNaves = 20;

        for (int i = 0; i < totalTiposNaves; i++) {
            String nombreNave = GeneradorNombresNaves.generarNombre();
            TipoNave tipoNave = new TipoNave(nombreNave);
            tipoNaveRepository.save(tipoNave);
        }
    }

    public class GeneradorNombresNaves {
        private static final String[] prefijos = { "Aurora", "Centella", "Fénix", "Estrella", "Galaxia", "Luna",
                "Nébula", "Orion", "Polaris", "Titan" };
        private static final String[] sufijos = { "X", "Y", "Z", "Omega", "Alfa", "Beta", "Gamma", "Delta", "Epsilon",
                "Zeta" };

        public static String generarNombre() {
            Random rand = new Random();
            int indexPrefijo = rand.nextInt(prefijos.length);
            int indexSufijo = rand.nextInt(sufijos.length);

            return prefijos[indexPrefijo] + " " + sufijos[indexSufijo];
        }
    }

    // aleatorio)
    private String generarContraseñaAleatoria() {
        return "contraseñaAleatoria";
    }

    private void crearRol() {
        if (RolRepository.findAll().isEmpty()) {
            Rol rol1 = new Rol();
            rol1.setNombreR("Piloto");
            RolRepository.save(rol1);
            Rol rol2 = new Rol();
            rol2.setNombreR("Comerciante");
            RolRepository.save(rol2);
            Rol rol3 = new Rol();
            rol3.setNombreR("Capitán");
            RolRepository.save(rol3);
        }
    }

    private void asignarProductosANave(Nave nave) {
        List<Producto> productos = productoRepository.findAll();
        Random random = new Random();
        int numProductos = random.nextInt(5) + 1; // Asigna entre 1 y 5 productos a la nave
    
        for (int i = 0; i < numProductos; i++) {
            int randomIndex = random.nextInt(productos.size());
            Producto producto = productos.get(randomIndex);
            nave.agregarProducto(producto, 10.0); // Agrega 10 unidades del producto a la nave
            productoRepository.save(producto); // Guarda el producto en la base de datos
        }
    
        naveRepository.save(nave); // Guarda la nave con los productos asignados
    }
    
}
