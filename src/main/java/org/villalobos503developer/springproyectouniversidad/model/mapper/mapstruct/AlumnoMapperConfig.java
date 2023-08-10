package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.villalobos503developer.springproyectouniversidad.model.dto.AlumnoDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Alumno;
@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{
    @InheritConfiguration(name = "mapPersona")
    void mapAlumno(Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);

}
