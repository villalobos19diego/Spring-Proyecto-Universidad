package org.villalobos503developer.springproyectouniversidad.service.contratos;

import org.villalobos503developer.springproyectouniversidad.model.entity.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {
    Iterable<Pabellon> findAllPabellonByLocalidad(String localidad);
    Iterable<Pabellon> findAllPabellonByNombre(String nombre);
}
