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

import com.uasz.Gestion_DAOS.Modele.maquette.Classe;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Modele.maquette.Groupe;
import com.uasz.Gestion_DAOS.Repository.maquette.EnseignementRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.GroupeRepository;
import com.uasz.Gestion_DAOS.Service.maquette.GroupeService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/groupe")
public class GroupeRestController {
    @Autowired
    private GroupeService groupeService;

    @Autowired
    private EnseignementRepository eRepository;

    @Autowired
    private GroupeRepository groupeRepository;

    @GetMapping
    private List<Groupe> lister_groupe(){
        return groupeService.rechercherGroupes();
    }

    @GetMapping(path = "/{id}")
    private Groupe rechercher_groupe(@PathVariable Long id){
        return groupeService.rechercherUneGroupe(id);
    }

    @PostMapping
    public Groupe ajouter_groupe(@RequestBody Groupe c){
        return groupeService.ajouter_groupe(c);
    }

    @PutMapping(path = "/{id}")
    public Groupe modifier_groupe(@PathVariable Long id, @RequestBody Groupe c){
        return groupeService.modifier_groupe( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_groupe(@PathVariable Long id){
        groupeService.supprimer_groupe(id);
    }

    @PutMapping(path = "{id}/enseignements/{idEnseignement}")
    public Groupe assigner_Enseignement(@PathVariable Long id,@PathVariable Long idEnseignement){
        Enseignement e = eRepository.findById(idEnseignement).get();
        Groupe g = groupeService.rechercherUneGroupe(id);
        e.setGroupe(g);
        eRepository.save(e);
        return groupeRepository.save(g);
    }

    @GetMapping("/{id}/enseignements")
    public List<Enseignement> afficherLesEnseignements(@PathVariable("id") Long id) {
       return groupeService.afficherEnseignements(id);
    }
}
