package org.villalobos503developer.springproyectouniversidad.service.contratos;

import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;

public interface AlumnoDAO extends PersonaDAO {
//    Iterable<Aula>findAulasByPizarron(Pizarron pizarron);
//    Iterable<Aula>findAulasByPabellonNombre(String nombre);
//    Optional<Aula> findAulaByNroAula(Integer nroAula);
Iterable<Persona> buscarAlumnosPorCarrera(String carrera);
}
