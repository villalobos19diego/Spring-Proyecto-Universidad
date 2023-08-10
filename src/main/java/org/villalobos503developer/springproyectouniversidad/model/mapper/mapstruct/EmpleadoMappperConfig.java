package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.villalobos503developer.springproyectouniversidad.model.dto.EmpleadoDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Empleado;

@MapperConfig
public interface EmpleadoMappperConfig extends PersonaMapperConfig{
    @InheritConfiguration(name = "mapPersona")
    void mapEmpleado(Empleado empleado, @MappingTarget EmpleadoDTO empleadoDTO);

}
