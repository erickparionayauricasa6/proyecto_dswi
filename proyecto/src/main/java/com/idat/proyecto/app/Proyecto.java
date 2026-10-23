/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.idat.proyecto.app;

import com.idat.proyecto.service.impl.ProductoServiceImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Proyecto {

    private static final Logger LOGGER = LogManager.getLogger(Proyecto.class);

    public static void main(String[] args) {
        String url = "http://localhost:8085/ws/productos";

        Endpoint.publish(url, new ProductoServiceImpl());

        LOGGER.info("Servicio SOAP de productos iniciado");
        LOGGER.info("WSDL disponible en {}?wsdl", url);
    }
}
