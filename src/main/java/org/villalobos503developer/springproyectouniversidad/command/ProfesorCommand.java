package org.villalobos503developer.springproyectouniversidad.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.ProfesorDAO;

import java.util.Optional;

@Component
@Order(1)
public class ProfesorCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("profesorDAOImpl")
    PersonaDAO personaDAO;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------- ************* Profesor Command ********** --------");
        personaDAO.save(ObjetosDummy.getProfesorUno());
        personaDAO.save(ObjetosDummy.getProfesorDos());
        System.out.println("----Busqueda todos los profesores ---");
        Iterable<Persona> profesores=((ProfesorDAO)personaDAO).findAll();
        profesores.forEach(System.out::println);

        System.out.println("----Busqueda por apellido---");
        Iterable<Persona> iPersona = personaDAO.findLastName(ObjetosDummy.getProfesorUno().getApellido());
        iPersona.forEach(System.out::println);
        System.out.println("---Busqueda de persona por DNI----");
        Optional<Persona> optionalPersona = personaDAO.findDni(ObjetosDummy.getProfesorDos().getDni());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));

        System.out.println("----Busqueda de persona por nombre y apellido");
        optionalPersona = personaDAO.findNameLastName(ObjetosDummy.getProfesorUno().getNombre(),ObjetosDummy.getProfesorDos().getApellido());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));
        System.out.println("----- Busqueda de profesor por carrera ----");
        Iterable<Persona> iProfesores = ((ProfesorDAO)personaDAO).buscarProfesoresPorCarrera(ObjetosDummy.getCarreraIngSis().getNombre());
        iProfesores.forEach(System.out::println);

    }
}
