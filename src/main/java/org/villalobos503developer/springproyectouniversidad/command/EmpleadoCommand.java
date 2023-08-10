package org.villalobos503developer.springproyectouniversidad.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.enums.TipoEmpleado;
import org.villalobos503developer.springproyectouniversidad.service.contratos.EmpleadoDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;

import java.util.Optional;

@Component
@Order(2)
public class EmpleadoCommand implements CommandLineRunner {
    @Autowired
    @Qualifier("empleadoDAOImpl")
    PersonaDAO personaDAO;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------- ************* Empleado Command ********** --------");
        personaDAO.save(ObjetosDummy.getEmpleadoUno());
        personaDAO.save(ObjetosDummy.getEmpleadoDos());
        System.out.println("----Busqueda todos los Empleados ---");
        Iterable<Persona> empleados=((EmpleadoDAO)personaDAO).findAll();
        empleados.forEach(System.out::println);

        System.out.println("----Busqueda por apellido---");
        Iterable<Persona> iPersona = personaDAO.findLastName(ObjetosDummy.getEmpleadoUno().getApellido());
        iPersona.forEach(System.out::println);
        System.out.println("---Busqueda de persona por DNI----");
        Optional<Persona> optionalPersona = personaDAO.findDni(ObjetosDummy.getEmpleadoDos().getDni());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));

        System.out.println("----Busqueda de persona por nombre y apellido");
        optionalPersona = personaDAO.findNameLastName(ObjetosDummy.getEmpleadoDos().getNombre(),ObjetosDummy.getEmpleadoUno().getApellido());
        optionalPersona.ifPresent(persona -> System.out.println(persona.toString()));
        System.out.println("----- Busqueda de persona por tipo empleado ----");
        Iterable<Persona> iEmpleados = ((EmpleadoDAO)personaDAO).buscarEmpleadosPorTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
        iEmpleados.forEach(System.out::println);

    }
}
