
package com.idat.proyecto.utils;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;


public class LocalDateAdaptador extends XmlAdapter<String, LocalDate> {

    
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return v == null || v.isBlank() ? null : LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v == null ? null : v.toString();
    }

}
/*
unmarshal
<fechaNacimiento>2026-12-07</fechaNacimiento>
LocalDate.of(2026,11,7)

marshal
LocalDate.of(2026,11,7)
<fechaNacimiento>2026-12-07</fechaNacimiento>

*/