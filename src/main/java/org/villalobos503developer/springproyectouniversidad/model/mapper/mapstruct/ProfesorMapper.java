package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.villalobos503developer.springproyectouniversidad.model.dto.ProfesorDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Profesor;

@Mapper(componentModel = "spring",config = PersonaMapperConfig.class)
public interface ProfesorMapper {
    ProfesorDTO mapProfesor(Profesor profesor);
    Profesor mapProfesor(ProfesorDTO profesorDTO);
}
