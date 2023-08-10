package org.villalobos503developer.springproyectouniversidad.controller;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/carreras")
@CrossOrigin(origins = "http://localhost:4200")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraDAO> {

    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }

    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo",required = false) Integer id){
        Optional<Carrera> optionalCarrera =service.findById(id);
        if (!optionalCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con di %d no existe",id));
        }
        return optionalCarrera.get();
    }



    @PostMapping("/busca-carreras")
    public Iterable<Carrera> findCarreraByNombreContains(@RequestParam String carrera){
        return service.findCarreraByNombreContains(carrera);
    }

    @PostMapping("/busca-carreras/ignorecase")
    public Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(@RequestParam String carrera){
        return service.findCarreraByNombreContainsIgnoreCase(carrera);
    }

    @PostMapping("/busca-carreras/{anios}")
    public Iterable<Carrera> findCarreraByCantidadAniosAfter(@PathVariable Integer anios){
            return service.findCarreraByCantidadAniosAfter(anios);
    }

    @PostMapping("/alta")

    public ResponseEntity<?> altacarrera(@Valid  @RequestBody Carrera carrera, BindingResult result){
//        if (carrera.getCantidadAnios()<0){
////            throw new BadRequestException("El campo de años no puede ser negativo");
//
//        }
//        if (carrera.getCantidadMaterias()<0){
//            throw new BadRequestException("El campo de cantidad de materias no puede ser negativo");
//        }
        Map<String,Object> validaciones =new HashMap<>();
        if (result.hasErrors()){
            result.getFieldErrors().forEach(error->validaciones.put(error.getField(),
                    error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }
        return ResponseEntity.ok(service.save(carrera));
    }
    @GetMapping("profesor-carreras/{nombre}/{apellido}")
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(@PathVariable String nombre,
                                                               @PathVariable String apellido){
        return service.buscarCarrerasPorProfesorNombreYApellido(nombre,apellido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String,Object> mensaje= new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> optionalCarrera = service.findById(id);
        if (!optionalCarrera.isPresent()){
//            throw new BadRequestException(String.format("La carrera con di %d no existe",id));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("La carrera con di %d no existe",id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        if (carrera.getCantidadAnios()<0){
//            throw new BadRequestException("El campo de años no puede ser negativo");
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje","El campo de años no puede ser negativo");
            return ResponseEntity.badRequest().body(mensaje);
        }
        if (carrera.getCantidadMaterias()<0){
//            throw new BadRequestException("El campo de cantidad de materias no puede ser negativo");
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje","El campo de cantidad de materias no puede ser negativo");
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate=optionalCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        mensaje.put("datos",service.save(carreraUpdate));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok().body(mensaje);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }
}
