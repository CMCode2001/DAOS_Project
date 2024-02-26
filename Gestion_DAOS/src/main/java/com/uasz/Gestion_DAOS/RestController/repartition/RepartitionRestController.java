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

import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Service.repartition.RepartitionService;


@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/repartition/repartition")
public class RepartitionRestController {

    @Autowired
    private RepartitionService rService;

    @GetMapping
    private List<Repartition> lister_repartition(){
        return rService.listerToutRepartition();
    }

    @GetMapping(path = "/{id}")
    private Repartition rechercher_repartition(@PathVariable Long id){
        return rService.rechercherRepartition(id);
    }

    @PostMapping
    public Repartition ajouter_repartition(@RequestBody Repartition c){
        return rService.ajouter_repartition(c);
    }

    @PutMapping(path = "/{id}")
    public Repartition modifier_repartition(@PathVariable Long id, @RequestBody Repartition c){
        return rService.modifier_repartition(c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_repartition(@PathVariable Long id){
        rService.supprimer_repartition(id);
    }
    
}
