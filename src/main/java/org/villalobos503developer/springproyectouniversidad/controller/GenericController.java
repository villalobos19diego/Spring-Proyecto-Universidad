package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.service.contratos.GenericoDAO;

import java.util.*;

@Deprecated
public class GenericController<E,S extends GenericoDAO<E>> {
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E>list=(List<E>)service.findAll();
        if (list.isEmpty()){
//            throw new BadRequestException(String.format("No se han encontrado %ss",nombreEntidad));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se han encontrado %ss",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",list);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public E altaEntidad(@RequestBody E entidad){
        return service.save(entidad);
    }

    @GetMapping("/{id}")
    public E obtenerPorId(@PathVariable(required = false) Integer id){
        Optional<E> oEntidad = service.findById(id);
        if(!oEntidad.isPresent()) {
            throw new BadRequestException(String.format("Entidad con id %d no existe", id));
        }
        return oEntidad.get();
    }


    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id){
        Optional<E> oEntidad = service.findById(id);
        if(!oEntidad.isPresent()) {
            throw new BadRequestException(String.format("Entidad con id %d no existe", id));
        }
        service.deleteById(id);
    }
}
