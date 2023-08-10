package org.villalobos503developer.springproyectouniversidad.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.villalobos503developer.springproyectouniversidad.model.entity.Pabellon;
import org.villalobos503developer.springproyectouniversidad.repository.PabellonRepository;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PabellonDAO;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pabellon> findAllPabellonByLocalidad(String localidad) {
        return repository.findAllPabellonByLocalidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findAllPabellonByNombre(String nombre) {
        return repository.findAllPabellonByNombre(nombre);
    }
}
