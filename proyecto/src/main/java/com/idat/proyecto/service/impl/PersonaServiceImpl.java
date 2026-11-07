package com.idat.proyecto.service.impl;

import com.idat.proyecto.dao.PersonaDAO;
import com.idat.proyecto.dao.impl.PersonaDAOImpl;
import com.idat.proyecto.model.Persona;
import com.idat.proyecto.service.PersonaService;
import com.idat.proyecto.utils.TipoBaseDatos;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebService(
        endpointInterface = "com.idat.proyecto.service.PersonaService",
        serviceName = "PersonaService"
)
public class PersonaServiceImpl implements PersonaService {

    private static final Logger LOGGER = LogManager.getLogger(PersonaServiceImpl.class);
    private final PersonaDAO personaDao;
    private final TipoBaseDatos tipoBaseDatos;

    public PersonaServiceImpl(TipoBaseDatos tipoBaseDatos) {
        this.tipoBaseDatos = tipoBaseDatos;
        this.personaDao = new PersonaDAOImpl(tipoBaseDatos);
    }

    @Override
    public int registrarPersona(Persona persona) throws PersonaServiceException {
        try {
            return personaDao.insertar(persona);
        } catch (SQLException | IllegalArgumentException ex) {
            throw manejarError("No se puede registrar la persona", ex);
        }
    }

    @Override
    public boolean actualizarPersona(Persona persona) throws PersonaServiceException {

        try {
            return personaDao.actualizar(persona);
        } catch (SQLException | IllegalArgumentException ex) {
            throw manejarError("No se puede actualizar la persona", ex);
        }
    }

    @Override
    public boolean eliminarPersona(int codigo) throws PersonaServiceException {
        try {
            return personaDao.eliminar(codigo);
        } catch (SQLException | IllegalArgumentException ex) {
            throw manejarError("No se puede eliminar la persona", ex);
        }
    }

    @Override
    public Persona buscarPersona(int codigo) throws PersonaServiceException  {

        try {
            return personaDao.listarPorId(codigo).orElse(null);
        } catch (SQLException | IllegalArgumentException ex) {
            throw manejarError("No se puede buscar la persona", ex);
        }
    }

    @Override
    public List<Persona> listarPersona() throws PersonaServiceException {
        try {
            return personaDao.listado();
        } catch (SQLException ex) {
            throw manejarError("No se puede consultar la informacion de la tabla persona", ex);
        }
    }

    
    public PersonaServiceException manejarError(String mensaje, Exception exception){
        LOGGER.error("{} ocurrio por {} - Error General: {} ", mensaje, exception, exception.getMessage());
        return new PersonaServiceException(mensaje, exception );
    }
    
    
}
