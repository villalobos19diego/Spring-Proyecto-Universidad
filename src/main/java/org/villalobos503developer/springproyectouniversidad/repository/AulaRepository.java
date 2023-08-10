package org.villalobos503developer.springproyectouniversidad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.villalobos503developer.springproyectouniversidad.model.entity.Aula;
import org.villalobos503developer.springproyectouniversidad.model.enums.Pizarron;

import java.util.Optional;

@Repository
public interface AulaRepository extends CrudRepository<Aula,Integer>{
    @Query("SELECT a FROM Aula a WHERE a.pizarron=?1")
    Iterable<Aula>findAulasByPizarron(Pizarron pizarron);

    @Query("SELECT a FROM Aula a JOIN FETCH a.pabellon p WHERE p.nombre = ?1")
    Iterable<Aula>findAulasByPabellonNombre(String nombre);

    @Query("SELECT a FROM Aula a WHERE a.nroAula=?1")
    Optional<Aula> findAulaByNroAula(Integer nroAula);
}
