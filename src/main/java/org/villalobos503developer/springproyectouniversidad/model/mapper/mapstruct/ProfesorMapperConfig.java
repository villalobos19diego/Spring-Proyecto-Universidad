package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.villalobos503developer.springproyectouniversidad.model.dto.ProfesorDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Profesor;

@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig {
    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);

}
