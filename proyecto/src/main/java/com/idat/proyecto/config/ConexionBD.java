package com.idat.proyecto.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConexionBD {

    private static final Logger LOGGER = LogManager.getLogger(ConexionBD.class);

    private static final String SERVIDOR = "localhost";
    private static final String BASE_DATOS = "proyecto";
    private static final String CONTRASENA = "123456";

    private static final int PUERTO_MYSQL = 3306;
    private static final String USUARIO_MYSQL = "root";

    private static final int PUERTO_SQL_SERVER = 1433;
    private static final String USUARIO_SQL_SERVER = "sa";

    private ConexionBD() {
        // Evita crear objetos de esta clase de utilidades.
    }

    public static Connection conectarMySQL() throws SQLException {
        String url = String.format(
                "jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC&connectTimeout=5000",
                SERVIDOR,
                PUERTO_MYSQL,
                BASE_DATOS
        );

        try {
            Connection conexion = DriverManager.getConnection(url, USUARIO_MYSQL, CONTRASENA);
            LOGGER.info("Conexión establecida con MySQL: {}/{}", SERVIDOR, BASE_DATOS);
            return conexion;
        } catch (SQLException ex) {
            LOGGER.error("No se pudo conectar con MySQL: {}/{}", SERVIDOR, BASE_DATOS, ex);
            throw ex;
        }
    }

    public static Connection conectarSqlServer() throws SQLException {
        String url = String.format(
                "jdbc:sqlserver://%s:%d;databaseName=%s;encrypt=true;trustServerCertificate=true;loginTimeout=5;",
                SERVIDOR,
                PUERTO_SQL_SERVER,
                BASE_DATOS
        );

        try {
            Connection conexion = DriverManager.getConnection(url, USUARIO_SQL_SERVER, CONTRASENA);
            LOGGER.info("Conexión establecida con SQL Server: {}/{}", SERVIDOR, BASE_DATOS);
            return conexion;
        } catch (SQLException ex) {
            LOGGER.error("No se pudo conectar con SQL Server: {}/{}", SERVIDOR, BASE_DATOS, ex);
            throw ex;
        }
    }
}
