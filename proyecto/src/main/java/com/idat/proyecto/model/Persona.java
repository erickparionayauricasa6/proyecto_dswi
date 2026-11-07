package com.idat.proyecto.model;
import com.idat.proyecto.utils.LocalDateAdaptador;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    @XmlJavaTypeAdapter(LocalDateAdaptador.class)
    private LocalDate fechaNacimiento;
    // LocalDate, LocalDateTime, LocalTime
    
}
