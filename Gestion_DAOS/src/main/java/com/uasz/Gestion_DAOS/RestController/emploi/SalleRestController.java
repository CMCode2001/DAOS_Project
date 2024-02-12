package com.uasz.Gestion_DAOS.RestController.emploi;

import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Service.emploi.SalleService;

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


/**
 * SalleRestController
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/emploi/salle")
public class SalleRestController {
    @Autowired
    private SalleService salleService;

    //GET
    @GetMapping 
    public List<Salle> lister_Salle(){
        return salleService.listerToutSalle();
    }

    @GetMapping(path = "/{id}")
    public Salle recherche_Salle(@PathVariable Long id){
        return salleService.recherche_Salle(id);
    }

    //POST
    @PostMapping
    public Salle ajouter_Salle(@RequestBody Salle Salle){
        return salleService.ajouter_Salle(Salle);
    }


    //PUT
     @PutMapping(path = "/{id}")
    public Salle modifier_Salle(@RequestBody Salle Salle, @PathVariable Long idBat){
        return salleService.modifier_Salle(Salle,idBat);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Salle(@PathVariable Long id){
        salleService.supprimer_Salle(id);
    }
    
}