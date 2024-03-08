package com.uasz.Gestion_DAOS.RestController.emploi;

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

import com.uasz.Gestion_DAOS.Modele.emploi.Deroulement;
import com.uasz.Gestion_DAOS.Repository.emploi.DeroulementRepository;
import com.uasz.Gestion_DAOS.Service.emploi.DeroulementService;

/**
 * DeroulementRestContoller
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploi/deroulement")
public class DeroulementRestContoller {
    @Autowired
    private DeroulementService deroulementService;
    
    //GET
    @GetMapping 
    public List<Deroulement> lister_Deroulement(){
        return deroulementService.listerToutDeroulement();
    }

    @GetMapping(path = "/{id}")
    public Deroulement recherche_Deroulement(@PathVariable Long id){
        return deroulementService.recherche_Deroulement(id);
    }

    //POST
    @PostMapping
    public Deroulement ajouter_Deroulement(@RequestBody Deroulement Deroulement){
        return deroulementService.ajouter_Deroulement(Deroulement);
    }


    //PUT
     @PutMapping(path = "/{id}")
    public Deroulement modifier_Deroulement(@RequestBody Deroulement Deroulement, @PathVariable Long id){
        return deroulementService.modifier_Deroulement(Deroulement,id);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Deroulement(@PathVariable Long id){
        deroulementService.supprimer_Deroulement(id);
    }


    
}