package org.villalobos503developer.springproyectouniversidad.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import org.villalobos503developer.springproyectouniversidad.model.entity.Aula;
import org.villalobos503developer.springproyectouniversidad.model.entity.Pabellon;
import org.villalobos503developer.springproyectouniversidad.model.enums.Pizarron;
import org.villalobos503developer.springproyectouniversidad.exception.BadRequestException;
import org.villalobos503developer.springproyectouniversidad.model.entity.*;
import org.villalobos503developer.springproyectouniversidad.service.contratos.AulaDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PabellonDAO;

import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/aulas")
@CrossOrigin(origins = "http://localhost:4200")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
public class AulaController extends GenericController<Aula, AulaDAO>{
    private final PabellonDAO pabellonDAO;
      public AulaController(AulaDAO service, PabellonDAO pabellonDAO) {
        super(service);
          this.pabellonDAO = pabellonDAO;
      }

    @PostMapping("/aulas-pizarras")
    public  Iterable<Aula>findAulasByPizarron(@RequestBody Pizarron pizarron){
          return service.findAulasByPizarron(pizarron);
    }
    @PostMapping("/aulas-pabellon")
    public Iterable<Aula>findAulasByPabellonNombre(@RequestBody String nombre){
          return service.findAulasByPabellonNombre(nombre);
    }
    @GetMapping("/nroaulas/{nroAula}")
    public Optional<Aula> findAulaByNroAula(@PathVariable Integer nroAula){
          return service.findAulaByNroAula(nroAula);
    }

    @PutMapping("/{idAula}/pabellon/{idPabellon}")
    public Aula asignarPabellonAula(@PathVariable Integer idAula, @PathVariable Integer idPabellon){
        Optional<Aula> oAula = service.findById(idAula);
        if(!oAula.isPresent()) {
            throw new BadRequestException(String.format("Aula con id %d no existe", idAula));
        }
        Optional<Pabellon> oPabellon = pabellonDAO.findById(idPabellon);
        if(!oPabellon.isPresent()){
            throw new BadRequestException(String.format("Pabellon con id %d no existe", idPabellon));
        }

        Pabellon pabellon = oPabellon.get();
        Aula aula = oAula.get();
        aula.setPabellon(pabellon);
        return service.save(aula);
    }

    @PutMapping("/{id}")
    public Aula actualizarAula(@PathVariable Integer id, @RequestBody Aula aula){
        Aula aulaUpdate = null;
        Optional<Aula> oAula = service.findById(id);
        if(!oAula.isPresent()) {
            throw new BadRequestException(String.format("Aula con id %d no existe", id));
        }
        aulaUpdate =  oAula.get();
        aulaUpdate.setNroAula(aula.getNroAula());
        aulaUpdate.setMedidas(aula.getMedidas());
        aulaUpdate.setPizarron(aula.getPizarron());
        aulaUpdate.setCantPupitres(aula.getCantPupitres());

        return service.save(aulaUpdate);
    }
}
