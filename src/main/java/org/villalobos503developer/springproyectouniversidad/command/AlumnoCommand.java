package org.villalobos503developer.springproyectouniversidad.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.villalobos503developer.springproyectouniversidad.model.entity.Alumno;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.service.contratos.AlumnoDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;

import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;
import java.util.Optional;

@Component
@Order(4)
public class AlumnoCommand implements CommandLineRunner {
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------- ************* Alumnos Command ********** --------");
        ((AlumnoDAO)personaDAO).save(ObjetosDummy.getAlumnoUno());
        ((AlumnoDAO)personaDAO).save(ObjetosDummy.getAlumnoDos());

        Iterable<Persona> alumnos=((AlumnoDAO)personaDAO).findAll();
        alumnos.forEach(System.out::println);
        System.out.println("Alumno ");
        Persona alumno =personaDAO.findById(5).orElseThrow();
        System.out.println(alumno);

        Carrera carrera= carreraDAO.findById(1).orElseThrow();
        ((Alumno)alumno).setCarrera(carrera);
        personaDAO.save(alumno);


        System.out.println("----Busqueda por apellido---");
        Iterable<Persona> iPersona = personaDAO.findLastName(ObjetosDummy.getAlumnoDos().getApellido());
        iPersona.forEach(System.out::println);
        System.out.println("---Busqueda de persona por DNI----");
        Optional<Persona> optionalPersona = personaDAO.findDni(ObjetosDummy.getAlumnoUno().getDni());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));

        System.out.println("----Busqueda de persona por nombre y apellido");
        optionalPersona = personaDAO.findNameLastName(ObjetosDummy.getProfesorUno().getNombre(),ObjetosDummy.getProfesorDos().getApellido());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));
        System.out.println("----- Busqueda de alumnos por carrera ----");
        Iterable<Persona> iAlumnos = ((AlumnoDAO)personaDAO).buscarAlumnosPorCarrera(ObjetosDummy.getCarreraIngSis().getNombre());
        iAlumnos.forEach(System.out::println);

    }
}
