package com.idat.proyecto.model;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private LocalDate fechaNacimiento;
    
}
