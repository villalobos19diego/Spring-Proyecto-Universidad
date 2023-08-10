package org.villalobos503developer.springproyectouniversidad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.villalobos503developer.springproyectouniversidad.model.entity.Pabellon;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon,Integer> {
    @Query("SELECT p FROM Pabellon p  WHERE p.direccion.localidad=?1")
    Iterable<Pabellon> findAllPabellonByLocalidad(String localidad);
    @Query("SELECT p FROM Pabellon p WHERE p.nombre=?1")
    Iterable<Pabellon> findAllPabellonByNombre(String nombre);

}
