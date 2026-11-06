package com.idat.proyecto.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConexionBD {

    private static final Logger LOGGER = LogManager.getLogger(ConexionBD.class);
    private static final Properties PROPS = new Properties();

    static {
        try (
                InputStream entrada = ConexionBD.class.getClassLoader().getResourceAsStream("database.properties");) {

            if (entrada == null) {
                LOGGER.error("No se encontro el archivo de configuracion");
            } else {
                PROPS.load(entrada);
            }
        } catch (IOException ex) {
            LOGGER.error("Error al cargar la configuración de la base de datos");
        }

    }

    // Configuracion para SQL SERVER
    private static final int PUERTO_SQL_SERVER = 1433;
    private static final String SERVIDOR_SQL_SERVER = "localhost";
    private static final String BASE_DATOS_SQL_SERVER = "proyecto";
    private static final String USUARIO_SQL_SERVER = "sa";
    private static final String CONTRASENA_SQL_SERVER = "sistemas";

    private ConexionBD() {
        // Evita crear objetos de esta clase de utilidades.
    }

    public static Connection conectarMySQL() throws SQLException, ClassNotFoundException {
        cargarDriverConexion("com.mysql.cj.jdbc.Driver", "MYSQL DB");

        String host = PROPS.getProperty("db.mysql.host", "localhost");
        int puerto = Integer.parseInt(PROPS.getProperty("db.mysql.port", "localhost"));
        String usuario = PROPS.getProperty("db.mysql.user", "localhost");
        String password = PROPS.getProperty("db.mysql.password", "localhost");
        String nombreBd = PROPS.getProperty("db.mysql.database", "localhost");

        String url = String.format(
                "jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC&connectTimeout=5000",
                host,
                puerto,
                nombreBd
        );

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            LOGGER.info("Conexión establecida con MySQL: {}/{}", host, nombreBd);
            return conexion;
        } catch (SQLException ex) {
            LOGGER.error("No se pudo conectar con MySQL: {}/{}", host, nombreBd, ex);
            throw ex;
        }
    }

    public static Connection conectarSqlServer() throws SQLException {
        String url = String.format(
                "jdbc:sqlserver://%s:%d;databaseName=%s;encrypt=true;trustServerCertificate=true;loginTimeout=5;",
                SERVIDOR_SQL_SERVER,
                PUERTO_SQL_SERVER,
                BASE_DATOS_SQL_SERVER
        );

        try {
            Connection conexion = DriverManager.getConnection(url, USUARIO_SQL_SERVER, CONTRASENA_SQL_SERVER);
            LOGGER.info("Conexión establecida con SQL Server: {}/{}", SERVIDOR_SQL_SERVER, BASE_DATOS_SQL_SERVER);
            return conexion;
        } catch (SQLException ex) {
            LOGGER.error("No se pudo conectar con SQL Server: {}/{}", SERVIDOR_SQL_SERVER, BASE_DATOS_SQL_SERVER, ex);
            throw ex;
        }
    }

    public static void cargarDriverConexion(String nombreClaseDriver, String gestor) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(nombreClaseDriver);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontro el driver de conexion del " + gestor, ex);
        }
    }

}
