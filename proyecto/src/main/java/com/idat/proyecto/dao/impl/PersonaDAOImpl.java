package com.idat.proyecto.dao.impl;

import com.idat.proyecto.dao.PersonaDAO;
import com.idat.proyecto.model.Persona;
import com.idat.proyecto.utils.TipoBaseDatos;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonaDAOImpl implements PersonaDAO {
    
    private static final Logger LOG = 
            LogManager.getLogger(PersonaDAOImpl.class);
    
    private TipoBaseDatos tipoBaseDatos;
    
    public PersonaDAOImpl(TipoBaseDatos tipoBaseDatos){
        if(tipoBaseDatos == null)
            throw new IllegalArgumentException("El gestor de bd es obligatorio");
        this.tipoBaseDatos=tipoBaseDatos;
    }
    
    @Override
    public int insertar(Persona objPersona) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Persona objPersona) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> listado() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Persona> listarPorId(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
