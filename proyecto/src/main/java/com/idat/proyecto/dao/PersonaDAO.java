package com.idat.proyecto.dao;
import com.idat.proyecto.model.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PersonaDAO {
    // 5 metodos
    int insertar(Persona objPersona) throws SQLException;

    boolean actualizar(Persona objPersona) throws SQLException;

    boolean eliminar(int codigo) throws SQLException;

    List<Persona> listado() throws SQLException;

    Optional<Persona> listarPorId(int codigo) throws SQLException;

}
