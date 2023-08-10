package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.entity.Profesor;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.ProfesorDAO;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Deprecated
@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = "http://localhost:4200")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class ProfesorController extends PersonaController{
    private final CarreraDAO carreraDAO;

    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO service, CarreraDAO carreraDAO) {
        super(service);
        this.carreraDAO = carreraDAO;
        nombreEntidad="Profesor";
    }
    @GetMapping("/profesores-carreras")
    public Iterable<Persona> buscarProfesoresPorCarrera(@RequestBody String carrera){
        return ((ProfesorDAO)service).buscarProfesoresPorCarrera(carrera);
    }

    @PutMapping("/{idProfesor}/carrera/{idCarrera}")
    public Persona asignarCarreraProfesor(@PathVariable Integer idProfesor, @PathVariable Integer idCarrera){
        Optional<Persona> oProfesor = service.findById(idProfesor);
        if(!oProfesor.isPresent()) {
            throw new BadRequestException(String.format("Profesor con id %d no existe", idProfesor));
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
        }

        Persona profesor = oProfesor.get();
        Carrera carrera = oCarrera.get();

        Set<Carrera> carreras = new HashSet<>();
        carreras.add(carrera);
        ((Profesor)profesor).setCarreras(carreras);
        return service.save(profesor);
    }

    @PutMapping("/{id}")
    public Persona actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor profesor){
        Profesor profesorUpdate = null;
        Optional<Persona> oProfesor = service.findById(id);
        if(!oProfesor.isPresent()) {
            throw new BadRequestException(String.format("Profesor con id %d no existe", id));
        }
        profesorUpdate = (Profesor) oProfesor.get();
        profesorUpdate.setNombre(profesor.getNombre());
        profesorUpdate.setApellido(profesor.getApellido());
        profesorUpdate.setDireccion(profesor.getDireccion());
        profesorUpdate.setSueldo(profesor.getSueldo());
        return service.save(profesorUpdate);
    }
}
