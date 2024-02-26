package com.uasz.Gestion_DAOS.RestController.repartition;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Service.repartition.VacataireService;






@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/repartition/vacataire")
public class VacataireRestController {

    @Autowired
    private VacataireService rService;

    @GetMapping
    private List<Vacataire> lister_vacataire(){
        return rService.lister_vacataires();
    }

    @GetMapping(path = "/{id}")
    private Vacataire rechercher_vacataire(@PathVariable Long id){
        return rService.rechercherVac(id);
    }

    @PostMapping
    public Vacataire ajouter_vacataire(@RequestBody Vacataire c){
        return rService.ajouter_vacataire(c);
    }

    @PutMapping(path = "/{id}")
    public Vacataire modifier_vacataire(@PathVariable Long id, @RequestBody Vacataire c){
        return rService.modifier_vacataire(c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_vacataire(@PathVariable Long id){
        rService.supprimer_vacataire(id);
    }
    
}
