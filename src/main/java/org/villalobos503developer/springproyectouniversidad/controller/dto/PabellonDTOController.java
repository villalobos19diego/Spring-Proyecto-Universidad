package org.villalobos503developer.springproyectouniversidad.controller.dto;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pabellones")


@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class PabellonDTOController {
}
