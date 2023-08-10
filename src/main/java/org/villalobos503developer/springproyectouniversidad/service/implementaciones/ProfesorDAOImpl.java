package org.villalobos503developer.springproyectouniversidad.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.entity.Profesor;
import org.villalobos503developer.springproyectouniversidad.repository.PersonaRepository;
import org.villalobos503developer.springproyectouniversidad.repository.ProfesorRepository;
import org.villalobos503developer.springproyectouniversidad.service.contratos.ProfesorDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {
    @Autowired
    public ProfesorDAOImpl(@Qualifier("profesorRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        // Llamada al método findAll() del repositorio que devuelve todas las personas (incluidos profesores y alumnos)
        Iterable<Persona> personas = super.findAll();

        // Filtrar las personas para obtener solo las instancias de Profesor
        List<Persona> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                profesores.add(persona);
            }
        }
        return profesores;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        Optional<Persona> optionalPersona=super.findById(id);
        Persona persona = optionalPersona.get();
        if (persona instanceof Profesor){
            return optionalPersona;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarProfesoresPorCarrera(String carrera) {
         return  ((ProfesorRepository)repository).buscarProfesoresPorCarrera(carrera);
    }
}
