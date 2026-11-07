package com.idat.proyecto.service;

import com.idat.proyecto.model.Persona;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface PersonaService {

    // Escrituras
    @WebMethod
    int registrarPersona(
            @WebParam(name = "persona") Persona persona
    );

    @WebMethod
    boolean actualizarPersona(
            @WebParam(name = "persona") Persona persona
    );

    @WebMethod
    boolean eliminarPersona(
            @WebParam(name = "codigo") int codigo
    );

    // Consultas
    @WebMethod
    Persona buscarPersona(
            @WebParam(name = "codigo") int codigo
    );

    @WebMethod
    List<Persona> listarPersona();

}
