package org.demospringangular.web;

import org.demospringangular.entities.Payment;
import org.demospringangular.entities.Ville;
import org.demospringangular.repository.VilleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VilleRestController {

    VilleRepository villeRepository;

    public VilleRestController(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @GetMapping(path = "/villes")
    public List<Ville> allPayments(){
        return villeRepository.findAll();
    }

}
