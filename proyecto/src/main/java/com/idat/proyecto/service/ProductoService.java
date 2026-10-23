package com.idat.proyecto.service;

import com.idat.proyecto.model.Producto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://soap.proyecto.idat.com/")
public interface ProductoService {

    @WebMethod
    String saludar(@WebParam(name = "nombre") String nombre);

    @WebMethod
    Producto buscarProducto(@WebParam(name = "id") int id);

    @WebMethod
    List<Producto> listarProductos();

    @WebMethod
    String registrarProducto(@WebParam(name = "producto") Producto producto);
}
