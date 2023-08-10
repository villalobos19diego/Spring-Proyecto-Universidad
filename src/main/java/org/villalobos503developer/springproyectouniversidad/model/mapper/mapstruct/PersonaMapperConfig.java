package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.villalobos503developer.springproyectouniversidad.model.dto.PersonaDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;

@MapperConfig
public interface PersonaMapperConfig {
    void mapPersona(Persona persona,@MappingTarget PersonaDTO PersonaDTO);
}
