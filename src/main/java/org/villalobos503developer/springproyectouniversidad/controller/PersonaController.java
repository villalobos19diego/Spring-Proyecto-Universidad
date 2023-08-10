package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
public class PersonaController extends GenericController<Persona, PersonaDAO> {
    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre,
                                                          @RequestParam String apellido){
        Map<String,Object> mensaje = new HashMap<>();
        Optional<Persona>optionalPersona =service.findNameLastName(nombre,apellido);
        if (!optionalPersona.isPresent()){
//            throw new BadRequestException(String.format("No se encontro persona con nombre "
//                    +"%s y appelido %s",nombre,apellido));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontro persona con nombre +%s y appelido %s",nombre,apellido));
            return ResponseEntity.badRequest().body(mensaje);
            }
        mensaje.put("datos",optionalPersona.get());
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok().body(mensaje);
    }
    @GetMapping("/persona-dni")
    public Persona buscarPorDni(@RequestParam String dni){
        Optional<Persona>optionalPersona =service.findDni(dni);
        if (!optionalPersona.isPresent()){
            throw new BadRequestException(String.format("No se encontro persona con DNI "
                    +"%s",dni));
        }
        return optionalPersona.get();
    }
}
