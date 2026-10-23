
package com.idat.proyecto.utils;

public class ConstantesBd {
    
    // Instrucciones DML
    // Insert tabla persona
    //insert into persona(nombres, apellidos, correo, fecha_nacimiento)
    //values (?,?,?,?)
    public static final String QUERY_PERSONA_INSERTAR=  
          """
          insert into persona(nombres, apellidos, 
                              correo, fecha_nacimiento) 
          values (?,?,?,?)
          """;
    // Actualizar tabla persona
    public static final String QUERY_PERSONA_ACTUALIZAR = 
            """
            update persona
            set nombres = ?, apellidos=?, 
                correo= ?, fecha_nacimiento=?
            where id = ?
            """;
    
    // Eliminar registro de tabla persona
    public static final String QUERY_PERSONA_ELIMINAR =
            """
            delete from persona 
            where id= ?
            """;
    
    // Listar registro de tabla persona
    public static final String QUERY_PERSONA_LISTAR=
            """
            select id, nombres, apellidos, correo, fecha_nacimiento
            from persona
            """;
    // Consultar por el identificador de la tabla persona
    public static final String QUERY_PERSONA_CONSULTAR_X_ID =
            """
            select id, nombres, apellidos, correo, fecha_nacimiento
            from persona where id=?
            """;
    
    
    
    
    
    
    
    
    
    
}
