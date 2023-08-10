package org.villalobos503developer.springproyectouniversidad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.villalobos503developer.springproyectouniversidad.model.Direccion;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProfesorDTO extends PersonaDTO {
    private BigDecimal sueldo;
    private Set<CarreraDTO>carreras;


    public ProfesorDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, Set<CarreraDTO> carreras) {
        super(id, nombre, apellido, dni, direccion);
        this.carreras = carreras;
    }
}
