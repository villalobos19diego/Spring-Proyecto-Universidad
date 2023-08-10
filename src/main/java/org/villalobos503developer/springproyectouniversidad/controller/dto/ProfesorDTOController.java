package org.villalobos503developer.springproyectouniversidad.controller.dto;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.dto.PersonaDTO;
import org.villalobos503developer.springproyectouniversidad.model.dto.ProfesorDTO;
import org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct.ProfesorMapper;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profesores")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class ProfesorDTOController extends PersonaDTOController{

    public ProfesorDTOController(@Qualifier("profesorDAOImpl") PersonaDAO service, ProfesorMapper profesorMapper) {
        super(service, "profesor", profesorMapper);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findProfesorId(@PathVariable Integer id) {
        Map<String, Object> mensaje = new HashMap<>();
        PersonaDTO dto = super.findPersonaId(id);
        if (dto == null) {
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existe %s con Id %d", nombre_entidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", dto);
        return ResponseEntity.ok().body(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaProfesor(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String,Object> mensaje = new HashMap<>();

        if (result.hasErrors()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("validaciones",super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }
        PersonaDTO save = super.altaPersona(profesorMapper.mapProfesor((ProfesorDTO) personaDTO));
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",save);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
}
