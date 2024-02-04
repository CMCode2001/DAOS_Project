package com.uasz.Gestion_DAOS.RestController.maquette;

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

import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Service.maquette.EnseignementService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/maquette/enseignement")
public class EnseignementRestController {
    @Autowired
    private EnseignementService eService;

    @GetMapping
    public List<Enseignement> lister_enseignement(){
        return eService.rechercherEnseignements();
    } 

    @GetMapping(path = "/{id}")
    public Enseignement recherche_enseignement(@PathVariable Long id){
        return eService.rechercherUneEnseignement(id);
    }

    @PostMapping
    public Enseignement ajouter_enseignement(@RequestBody Enseignement e){
        return eService.ajouter_enseignement(e);
    }

    @PutMapping(path = "/{id}")
    public Enseignement modifier_enseignement(@PathVariable Long id, @RequestBody Enseignement e){
        return eService.modifier_enseignement(e, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_enseignement(@PathVariable Long id ){
        eService.supprimer_enseignement(id);
    }
    
}
