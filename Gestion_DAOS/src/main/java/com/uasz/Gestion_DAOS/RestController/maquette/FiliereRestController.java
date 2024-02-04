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

import com.uasz.Gestion_DAOS.Modele.maquette.Filiere;
import com.uasz.Gestion_DAOS.Service.maquette.FiliereService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/maquette/filiere")
public class FiliereRestController {
    @Autowired
    private FiliereService fService;

    @GetMapping
    public List<Filiere> lister_filiere(){
        return fService.rechercherFilieres();
    } 

    @GetMapping(path = "/{id}")
    public Filiere recherche_filiere(@PathVariable Long id){
        return fService.rechercherUneFiliere(id);
    }

    @PostMapping
    public Filiere ajouter_filiere(@RequestBody Filiere f){
        return fService.ajouter_filiere(f);
    }

    @PutMapping(path = "/{id}")
    public Filiere modifier_filiere(@PathVariable Long id, @RequestBody Filiere f){
        return fService.modifier_filiere(f, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_filiere(@PathVariable Long id ){
        fService.supprimer_filiere(id);
    }
}
