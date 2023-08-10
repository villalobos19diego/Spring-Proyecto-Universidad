package org.villalobos503developer.springproyectouniversidad.service.contratos;

import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;

public interface ProfesorDAO extends PersonaDAO {
    Iterable<Persona> buscarProfesoresPorCarrera(String carrera);
}
