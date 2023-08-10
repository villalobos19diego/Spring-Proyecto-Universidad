package org.villalobos503developer.springproyectouniversidad.service.contratos;

import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona> {
    Optional<Persona> findNameLastName(String nombre,String apellido);
    Optional<Persona> findDni(String dni);
    Iterable<Persona> findLastName(String apellido);
}
