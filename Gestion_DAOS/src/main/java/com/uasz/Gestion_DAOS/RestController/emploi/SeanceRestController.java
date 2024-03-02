package com.uasz.Gestion_DAOS.RestController.emploi;

import java.util.Date;
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

import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Service.emploi.SeanceService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploi/seance")
public class SeanceRestController {
     @Autowired
    private SeanceService seanceService;

    //GET
    @GetMapping 
    public List<Seance> lister_Seance(){
        return seanceService.listerToutSeance();
    }

    @GetMapping(path = "/{id}")
    public Seance recherche_Seance(@PathVariable Long id){
        return seanceService.recherche_Seance(id);
    }

    //POST
    @PostMapping
    public Seance ajouter_Seance(@RequestBody Seance seance){
        seance.setDateCreationSeance(new Date(System.currentTimeMillis()));
        return seanceService.ajouter_Seance(seance);
    }


    //PUT
     @PutMapping(path = "/{id}")
    public Seance modifier_Seance(@RequestBody Seance seance, @PathVariable Long idBat){
        return seanceService.modifier_Seance(seance,idBat);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Seance(@PathVariable Long id){
        seanceService.supprimer_Seance(id);
    }
}
