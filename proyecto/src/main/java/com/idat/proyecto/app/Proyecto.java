package com.idat.proyecto.app;

import com.idat.proyecto.service.impl.PersonaServiceImpl;
import com.idat.proyecto.utils.TipoBaseDatos;
import jakarta.xml.ws.Endpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Proyecto {

    private static final Logger LOGGER = LogManager.getLogger(Proyecto.class);
    private static final TipoBaseDatos BASE_DATOS = TipoBaseDatos.MYSQL;

    public static void main(String[] args) {
        /*
        String url = "http://localhost:8085/ws/productos";
        Endpoint.publish(url, new ProductoServiceImpl());
        LOGGER.info("Servicio SOAP de productos iniciado");
        LOGGER.info("WSDL disponible en {}?wsdl", url);
         */

        String url = "http://localhost:8085/ws/persona";
        Endpoint.publish(url, new PersonaServiceImpl(BASE_DATOS));

        LOGGER.info("Servicio SOAP de persona iniciado");
        LOGGER.info("WSDL disponible en {}?wsdl", url);

    }
}
