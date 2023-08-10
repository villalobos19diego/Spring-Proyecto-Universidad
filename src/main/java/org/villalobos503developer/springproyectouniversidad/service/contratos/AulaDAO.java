package org.villalobos503developer.springproyectouniversidad.service.contratos;

import org.villalobos503developer.springproyectouniversidad.model.entity.Aula;
import org.villalobos503developer.springproyectouniversidad.model.enums.Pizarron;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula> {
    Iterable<Aula>findAulasByPizarron(Pizarron pizarron);

    Iterable<Aula>findAulasByPabellonNombre(String nombre);

    Optional<Aula> findAulaByNroAula(Integer nroAula);
}
