package org.villalobos503developer.springproyectouniversidad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.villalobos503developer.springproyectouniversidad.model.Direccion;
import org.villalobos503developer.springproyectouniversidad.model.entity.Pabellon;
import org.villalobos503developer.springproyectouniversidad.model.enums.TipoEmpleado;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmpleadoDTO extends PersonaDTO{
    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;
    private Pabellon pabellon;

    public EmpleadoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado, Pabellon pabellon) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
        this.pabellon = pabellon;
    }
}
