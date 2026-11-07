
package com.idat.proyecto.service.impl;

import jakarta.xml.ws.WebFault;


@WebFault(name = "PersonaServiceFault")
public class PersonaServiceException extends Exception {
    
    
    public PersonaServiceException(String mensajeError){
        super(mensajeError);
    }

    public PersonaServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
    
}
