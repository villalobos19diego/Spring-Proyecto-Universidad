package org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.villalobos503developer.springproyectouniversidad.model.dto.EmpleadoDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Empleado;

@Mapper(componentModel = "spring",config = EmpleadoMappperConfig.class)
public  interface EmpleadoMapper {
    EmpleadoDTO mapEmpleado(Empleado empleado);
    Empleado mapEmpleado(EmpleadoDTO empleadoDTO);

}
