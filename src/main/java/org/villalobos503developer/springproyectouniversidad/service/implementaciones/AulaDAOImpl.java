package org.villalobos503developer.springproyectouniversidad.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.villalobos503developer.springproyectouniversidad.model.entity.Aula;
import org.villalobos503developer.springproyectouniversidad.model.enums.Pizarron;
import org.villalobos503developer.springproyectouniversidad.repository.AulaRepository;
import org.villalobos503developer.springproyectouniversidad.service.contratos.AulaDAO;

import java.util.Optional;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {


    @Autowired
    public AulaDAOImpl( AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findAulasByPizarron(Pizarron pizarron) {
        return repository.findAulasByPizarron(pizarron);
    }

    @Override
    public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
        return repository.findAulasByPabellonNombre(nombre);
    }

    @Override
    public Optional<Aula> findAulaByNroAula(Integer nroAula) {
        return repository.findAulaByNroAula(nroAula);
    }

}
