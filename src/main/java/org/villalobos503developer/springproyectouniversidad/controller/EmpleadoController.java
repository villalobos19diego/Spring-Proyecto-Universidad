package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.entity.Empleado;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.enums.TipoEmpleado;
import org.villalobos503developer.springproyectouniversidad.service.contratos.EmpleadoDAO;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;

import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:4200")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class EmpleadoController  extends PersonaController{


    public EmpleadoController(@Qualifier("empleadoDAOImpl") PersonaDAO service) {
        super(service);
        nombreEntidad = "Empleado";
    }

    @GetMapping("/tipo-empleado")
    public Iterable<Persona> buscarEmpleadosPorTipoEmpleado(@RequestBody TipoEmpleado tipoEmpleado){
        return ((EmpleadoDAO)service).buscarEmpleadosPorTipoEmpleado(tipoEmpleado);
    }

    @PutMapping("/{id}")
    public Persona actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado){
        Empleado empleadoUpdate;
        Optional<Persona> oEmpleado = service.findById(id);
        if(!oEmpleado.isPresent()) {
            throw new BadRequestException(String.format("Empleado con id %d no existe", id));
        }
        empleadoUpdate = (Empleado) oEmpleado.get();
        empleadoUpdate.setNombre(empleado.getNombre());
        empleadoUpdate.setApellido(empleado.getApellido());
        empleadoUpdate.setDireccion(empleado.getDireccion());
        empleadoUpdate.setTipoEmpleado(empleado.getTipoEmpleado());
        empleadoUpdate.setSueldo(empleado.getSueldo());
        return service.save(empleadoUpdate);
    }
}