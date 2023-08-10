package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping("/restapi")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class PrimerRestController {
    @GetMapping("/hola-mundo")
    public ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola mundo! =D", HttpStatus.ACCEPTED);
    }
}
