package com.idat.proyecto.dao.impl;

import com.idat.proyecto.config.ConexionBD;
import com.idat.proyecto.dao.PersonaDAO;
import com.idat.proyecto.model.Persona;
import com.idat.proyecto.utils.ConstantesBd;
import com.idat.proyecto.utils.TipoBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonaDAOImpl implements PersonaDAO {

    private static final Logger LOG
            = LogManager.getLogger(PersonaDAOImpl.class);

    private TipoBaseDatos tipoBaseDatos;

    public PersonaDAOImpl(TipoBaseDatos tipoBaseDatos) {
        if (tipoBaseDatos == null) {
            throw new IllegalArgumentException("El gestor de bd es obligatorio");
        }
        this.tipoBaseDatos = tipoBaseDatos;
    }

    @Override
    public int insertar(Persona objPersona) throws SQLException {
        //Connection PreparedStatement
        try (
                Connection con = conexionBd(); PreparedStatement sentencia = con.prepareStatement(
                        ConstantesBd.QUERY_PERSONA_INSERTAR,
                        Statement.RETURN_GENERATED_KEYS);) {

            asignacionParametros(sentencia, objPersona);
            if (sentencia.executeUpdate() == 0) {
                throw new SQLException("Error al ejecutar la sentencia de insercion");
            }
            try (
                    ResultSet resultado = sentencia.getGeneratedKeys();) {
                if (resultado.next()) {
                    int codigo = resultado.getInt(1);
                    objPersona.setId(codigo);
                    return codigo;
                }
            }
            throw new SQLException("Error al generar el codigo");
        }
    }

    private Connection conexionBd() throws SQLException {
        return switch (tipoBaseDatos) {
            case MYSQL ->
                ConexionBD.conectarMySQL();
            case SQLSERVER ->
                ConexionBD.conectarSqlServer();
            default ->
                throw new SQLException("El SGBD no es soportado en el proyecto");
        };
    }

    @Override
    public boolean actualizar(Persona objPersona) throws SQLException {
        try (
                Connection con = conexionBd(); PreparedStatement sentencia = con.prepareStatement(
                        ConstantesBd.QUERY_PERSONA_ACTUALIZAR);) {
            asignacionParametros(sentencia, objPersona);
            sentencia.setInt(5, objPersona.getId());
            return sentencia.executeUpdate() > 0;
        }
    }

    public void asignacionParametros(PreparedStatement sentencia,
            Persona objPersona
    ) throws SQLException {
        sentencia.setString(1, objPersona.getNombres());
        sentencia.setString(2, objPersona.getApellidos());
        sentencia.setString(3, objPersona.getCorreo());
        sentencia.setDate(4, Date.valueOf(objPersona.getFechaNacimiento()));
    }

    @Override
    public boolean eliminar(int codigo) throws SQLException {
        
        try (
                Connection con = conexionBd(); 
                PreparedStatement sentencia = con.prepareStatement(
                        ConstantesBd.QUERY_PERSONA_ELIMINAR);) {
            
            sentencia.setInt(1, codigo);
            return sentencia.executeUpdate() > 0;
        }
    }

    @Override
    public List<Persona> listado() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Persona> listarPorId(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void validarCodigo(int codigo){
        if (codigo<=0){
            throw new IllegalArgumentException("El codigo no puede ser menor a 1");
        }
    }
    
    public void validarDatosPersona(Persona objPersona){
        
        if (objPersona == null){
            throw new IllegalArgumentException("Los datos de la persona es obligatoria");
        }
        
        if (objPersona.getNombres() == null  || objPersona.getNombres().isBlank()){
            throw new IllegalArgumentException("El nombre de la persona es obligatorio");
        }
        
        if (objPersona.getApellidos()== null || objPersona.getApellidos().isBlank()){
            throw new IllegalArgumentException("El apellido de la persona es obligatorio");
        }
        
        if (objPersona.getFechaNacimiento() == null){
            throw new IllegalArgumentException("La fecha de nacimiento es obligatorio");
        }
        
        if (objPersona.getFechaNacimiento().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de nacimiento no debe ser posterior a hoy");
        }
        
        
    }
    
    
    
    
    
    

}
