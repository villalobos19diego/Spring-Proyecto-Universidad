package org.villalobos503developer.springproyectouniversidad.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;

import java.util.List;

@Component
@Order(2)
public class CarreraComandos implements CommandLineRunner {
    private final CarreraDAO servicio;
    public CarreraComandos(CarreraDAO servicio) {
        this.servicio = servicio;
    }

    @Override
    public void run(String... args) throws Exception {
//        Carrera ingSistemas = new Carrera(null,"Ingenieria en sistemas",50,5);
//        Carrera save =servicio.save(ingSistemas);
//        System.out.println(save.toString());
//        Carrera carrera = null;
//        Optional<Carrera> oCarrera=servicio.findById(1);
//        if (oCarrera.isPresent()){
//            carrera = oCarrera.get();
//            System.out.println(carrera.toString());
//        }else {
//            System.out.println("Carrera no existe");
//        }
//        carrera.setCantidadMaterias(65);
//        carrera.setCantidadAnios(6);
//
//        servicio.save(carrera);
//        System.out.println(servicio.findById(1).orElse(new Carrera()).toString());
//        servicio.deleteById(1);
//        System.out.println(servicio.findById(1).orElse(new Carrera()).toString());

        Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        servicio.save(ingSistemas);
        servicio.save(ingIndustrial);
        servicio.save(ingAlimentos);
        servicio.save(ingElectronica);
        servicio.save(licSistemas);
        servicio.save(licTurismo);
        servicio.save(licYoga);
        servicio.save(licRecursos);

        System.out.println("Todas las carreras");
        List<Carrera> carreras =(List<Carrera>) servicio.findAll();
           carreras.forEach(System.out::println);
        System.out.println("findCarreraByNombreContains");
        carreras =(List<Carrera>) servicio.findCarreraByNombreContains("Sistemas");
        carreras.forEach(System.out::println);
        System.out.println("findCarreraByNombreContainsIgnoreCase Mayusculas");
        carreras =(List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase("SISTEMAS");
        carreras.forEach(System.out::println);
        System.out.println("findCarreraByNombreContainsIgnoreCase minusculas");
        carreras =(List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase("sistemas");
        carreras.forEach(System.out::println);

        System.out.println("findCarreraByCantidadAniosAfter");
        carreras =(List<Carrera>) servicio.findCarreraByCantidadAniosAfter(5);
        carreras.forEach(System.out::println);

        System.out.println("Buscar carrera por nombre y apellido");
        carreras =(List<Carrera>) servicio.buscarCarrerasPorProfesorNombreYApellido(
                ObjetosDummy.getProfesorUno().getNombre(),ObjetosDummy.getProfesorUno().getApellido());
        carreras.forEach(System.out::println);
    }
}
