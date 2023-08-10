package org.villalobos503developer.springproyectouniversidad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.enums.TipoEmpleado;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends PersonaRepository{
    @Query("SELECT e FROM Empleado e  WHERE e.tipoEmpleado=?1")
    Iterable<Persona> buscarEmpleadosPorTipoEmpleado(TipoEmpleado tipoEmpleado);
}
