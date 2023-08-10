package org.villalobos503developer.springproyectouniversidad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Direccion implements Serializable {
    private String calle;
    private  String numero;
    private String codigoPostal;
    private String depto;
    private String piso;
    private String localidad;

    @Override
    public String toString() {
        return " calle: " + calle +
                ", numero: " + numero +
                ", codigoPostal: " + codigoPostal +
                ", depto: " + depto +
                ", piso: " + piso +
                ", localidad: " + localidad;
    }
}
