package com.idat.proyecto.service.impl;

import com.idat.proyecto.model.Producto;
import com.idat.proyecto.service.ProductoService;
import jakarta.jws.WebService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebService(
        endpointInterface = "com.idat.proyecto.service.ProductoService",
        serviceName = "ProductoService",
        portName = "ProductoPort",
        targetNamespace = "http://soap.proyecto.idat.com/"
)
public class ProductoServiceImpl implements ProductoService {

    private static final Logger LOGGER = LogManager.getLogger(ProductoServiceImpl.class);
    private final List<Producto> productos = new CopyOnWriteArrayList<>();

    public ProductoServiceImpl() {
        productos.add(new Producto(1, "Laptop", 2499.90));
        productos.add(new Producto(2, "Mouse", 59.90));
        productos.add(new Producto(3, "Teclado", 129.90));
    }

    @Override
    public String saludar(String nombre) {
        LOGGER.info("Solicitud de saludo para {}", nombre);
        return "Hola " + nombre + ", bienvenido al servicio SOAP de productos";
    }

    @Override
    public Producto buscarProducto(int id) {
        LOGGER.info("Buscando producto con id {}", id);
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> listarProductos() {
        LOGGER.info("Listando {} productos", productos.size());
        return List.copyOf(productos);
    }

    @Override
    public String registrarProducto(Producto producto) {
        if (producto == null || producto.getId() <= 0 || producto.getNombre() == null
                || producto.getNombre().isBlank() || producto.getPrecio() < 0) {
            LOGGER.warn("Se intentó registrar un producto con datos inválidos");
            return "Datos de producto inválidos";
        }

        boolean idDuplicado = productos.stream()
                .anyMatch(registrado -> registrado.getId() == producto.getId());
        if (idDuplicado) {
            LOGGER.warn("El producto con id {} ya existe", producto.getId());
            return "El ID ya existe";
        }

        productos.add(producto);
        LOGGER.info("Producto {} registrado correctamente", producto.getId());
        return "Producto registrado correctamente";
    }
}
