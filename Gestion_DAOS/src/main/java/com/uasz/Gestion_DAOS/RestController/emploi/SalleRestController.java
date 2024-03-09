package com.uasz.Gestion_DAOS.RestController.emploi;

import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Service.emploi.SalleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


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
    public Salle ajouter_Salle(@RequestBody Salle salle){
        return salleService.ajouter_Salle(salle);
    }



    @PutMapping(path = "/{id}")
    public Salle modifier_Salle(@RequestBody Salle salle, @PathVariable Long id){
        return salleService.modifier_Salle(salle, id); // Pass the correct parameters
    }



    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Salle(@PathVariable Long id){
        salleService.supprimer_Salle(id);
    }

    @PostMapping("/{id}/seances")
    @ResponseStatus(HttpStatus.OK)
    public Seance ajouterSeanceDansSalle (@PathVariable("id") Long id, @RequestBody Seance s) {
        Salle b = salleService.recherche_Salle(id);
        salleService.ajouterSeanceDansSalle(b, s);
        return s;
    }

    @GetMapping("/{id}/seances")
    public List<Seance> afficherSeances(@PathVariable("id") Long id) {
       return salleService.afficherLesSeances(id);
    }
    
}