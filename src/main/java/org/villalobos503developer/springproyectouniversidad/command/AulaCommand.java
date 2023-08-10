package org.villalobos503developer.springproyectouniversidad.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.villalobos503developer.springproyectouniversidad.model.enums.Pizarron;
import org.villalobos503developer.springproyectouniversidad.service.contratos.AulaDAO;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PabellonDAO;

@Component
@Order(5)
public class AulaCommand implements CommandLineRunner {
    @Autowired
    private AulaDAO aulaDAO;
    @Autowired
    private PabellonDAO pabellonDAO;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------- ************* Aula Command ********** --------");
        aulaDAO.save(ObjetosDummy.getAula123());
        aulaDAO.save(ObjetosDummy.getAula451());
        System.out.println("--- buscar por numero aula ---");
        System.out.println(aulaDAO.findAulaByNroAula(ObjetosDummy.getAula123().getNroAula()));
//        Pabellon pabellon=pabellonDAO.findById(1).orElseThrow();
        aulaDAO.findAulasByPizarron(Pizarron.PIZARRA_ACRILICO);
//        aulaDAO.findAulasByPabellonNombre(pabellon.toString());

    }
}
