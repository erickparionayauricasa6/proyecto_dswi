package com.idat.proyecto.app;

import com.idat.proyecto.config.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TestConexion {

    private static final Logger LOGGER = LogManager.getLogger(TestConexion.class);
    private static final int TIEMPO_ESPERA_SEGUNDOS = 5;

    private TestConexion() {
        // Evita crear objetos de esta clase de utilidades.
    }

    public static void main(String[] args) {
        boolean mysqlConectado = probarMySQL();
        boolean sqlServerConectado = probarSqlServer();

        LOGGER.info("Resultado MySQL: {}", mysqlConectado ? "CONECTADO" : "NO CONECTADO");
        LOGGER.info("Resultado SQL Server: {}", sqlServerConectado ? "CONECTADO" : "NO CONECTADO");
    }

    public static boolean probarMySQL() {
        try (Connection conexion = ConexionBD.conectarMySQL()) {

            boolean conexionValida = conexion.isValid(TIEMPO_ESPERA_SEGUNDOS);
            LOGGER.info("Prueba de conexión MySQL: {}", conexionValida ? "CORRECTA" : "FALLIDA");
            return conexionValida;
        } catch (SQLException ex) {
            LOGGER.error("Falló la prueba de conexión con MySQL", ex);
            return false;
        }
    }

    public static boolean probarSqlServer() {
        try (Connection conexion = ConexionBD.conectarSqlServer()) {

            boolean conexionValida = conexion.isValid(TIEMPO_ESPERA_SEGUNDOS);
            LOGGER.info("Prueba de conexión SQL Server: {}", conexionValida ? "CORRECTA" : "FALLIDA");
            return conexionValida;
        } catch (SQLException ex) {
            LOGGER.error("Falló la prueba de conexión con SQL Server", ex);
            return false;
        }
    }
}
