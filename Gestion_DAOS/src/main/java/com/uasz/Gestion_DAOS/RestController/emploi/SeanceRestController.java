package com.uasz.Gestion_DAOS.RestController.emploi;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Modele.emploi.Deroulement;
import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Repository.emploi.SalleRepository;
import com.uasz.Gestion_DAOS.Repository.emploi.SeanceRepository;
import com.uasz.Gestion_DAOS.Service.emploi.SeanceService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploi/seance")
public class SeanceRestController {
     @Autowired
    private SeanceService seanceService;

    @Autowired 
    private SalleRepository sRepository;

    @Autowired
    private SeanceRepository seanceRepository;

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
    public Seance modifier_Seance(@RequestBody Seance seance, @PathVariable Long id){
        return seanceService.modifier_Seance(seance,id);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Seance(@PathVariable Long id){
        seanceService.supprimer_Seance(id);
    }

    @PutMapping(path = "{id}/salles/{idSalle}")
    public Seance ajouter_Salle_Seance(@PathVariable Long id,@PathVariable Long idSalle){
        Salle s = sRepository.findById(idSalle).get();
        Seance se = seanceService.recherche_Seance(id);
        se.setSalle(s);
       sRepository.save(s);

        return seanceRepository.save(se);
       
    }

    @GetMapping(path = "{id}/salles")
    public Salle salleAssigner(@PathVariable Long id){
        return seanceService.salle_assigner(id);
    }

    
    @PostMapping("/{id}/deroulement")
    @ResponseStatus(HttpStatus.OK)
    public Deroulement ajouterDeroulement (@PathVariable("id") Long id, @RequestBody Deroulement d) {
        Seance s = seanceService.recherche_Seance(id);
        seanceService.ajouter_Deroulement(d, s);
        return d;
    }

}
