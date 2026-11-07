package com.idat.proyecto.service;

import com.idat.proyecto.model.Persona;
import com.idat.proyecto.service.impl.PersonaServiceException;
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
    ) throws PersonaServiceException;

    @WebMethod
    boolean actualizarPersona(
            @WebParam(name = "persona") Persona persona
    ) throws PersonaServiceException;

    @WebMethod
    boolean eliminarPersona(
            @WebParam(name = "codigo") int codigo
    ) throws PersonaServiceException;

    // Consultas
    @WebMethod
    Persona buscarPersona(
            @WebParam(name = "codigo") int codigo
    ) throws PersonaServiceException;

    @WebMethod
    List<Persona> listarPersona() throws PersonaServiceException;

}
