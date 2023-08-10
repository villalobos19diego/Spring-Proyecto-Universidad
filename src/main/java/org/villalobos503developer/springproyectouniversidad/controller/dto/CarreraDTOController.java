package org.villalobos503developer.springproyectouniversidad.controller.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.villalobos503developer.springproyectouniversidad.model.dto.CarreraDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct.CarreraMapperMs;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class CarreraDTOController {

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    CarreraMapperMs mapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String,Object> mensaje= new HashMap<>();
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        List<CarreraDTO> dtos = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",dtos);
        return ResponseEntity.ok().body(mensaje);
    }
}
