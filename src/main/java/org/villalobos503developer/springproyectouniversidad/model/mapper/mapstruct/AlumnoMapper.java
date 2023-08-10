package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.villalobos503developer.springproyectouniversidad.model.dto.AlumnoDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Alumno;


@Mapper(componentModel = "spring",config = AlumnoMapperConfig.class,uses = CarreraMapperMs.class)
public interface AlumnoMapper {
     AlumnoDTO mapAlumnoDTO(Alumno alumno);
     Alumno mapAlumno(AlumnoDTO alumnoDTO);

}
