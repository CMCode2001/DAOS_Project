package com.uasz.Gestion_DAOS.RestController.repartition;

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

import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Service.repartition.EnseignantService;




@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/repartition/enseignant")
public class EnseignantRestController {

    @Autowired
    private EnseignantService eService;

    @GetMapping
    private List<Enseignant> lister_enseignant(){
        return eService.lister_enseignant();
    }

    @GetMapping(path = "/{id}")
    private Enseignant rechercher_enseignant(@PathVariable Long id){
        return eService.rechercher_enseignant(id);
    }

    @PostMapping
    public Enseignant ajouter_enseignant(@RequestBody Enseignant c){
        return eService.ajouter_enseignant(c);
    }

    @PutMapping(path = "/{id}")
    public Enseignant modifier_enseignant(@PathVariable Long id, @RequestBody Enseignant c){
        return eService.modifier_enseignant(c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_enseignant(@PathVariable Long id){
        eService.supprimer_enseignant(id);
    }


    @GetMapping("/{id}/repartitions")
    public List<Repartition> getRepartitionsForEnseignant(@PathVariable Long id) {
        return eService.obtenirRepartitionsPourEnseignant(id);
    }

    @PostMapping("/{id}/repartitions")
    public Repartition ajouterRepartitionPourEnseignant(@PathVariable Long id, @RequestBody Repartition repartition) {
        eService.ajouterRepartitionPourEnseignant(id, repartition);
        return repartition;
    }


    
}
