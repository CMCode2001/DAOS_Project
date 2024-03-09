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
import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Modele.maquette.Niveau;
import com.uasz.Gestion_DAOS.Repository.maquette.FormationRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.NiveauRepository;
import com.uasz.Gestion_DAOS.Service.maquette.NiveauService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/niveau")
public class NiveauRestController {
    @Autowired
    private NiveauService niveauService;

    @Autowired
    private FormationRepository fRepository;
    
    @Autowired
    private NiveauRepository nRepository;

    @GetMapping
    private List<Niveau> lister_niveau(){
        return niveauService.rechercherNiveaux();
    }

    @GetMapping(path = "/{id}")
    private Niveau rechercher_niveau(@PathVariable Long id){
        return niveauService.rechercherUnNiveau(id);
    }

    @PostMapping
    public Niveau ajouter_niveau(@RequestBody Niveau c){
        return niveauService.ajouter_niveau(c);
    }

    @PutMapping(path = "/{id}")
    public Niveau modifier_niveau(@PathVariable Long id, @RequestBody Niveau c){
        return niveauService.modifier_niveau( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_niveau(@PathVariable Long id){
        niveauService.supprimer_niveau(id);
    }

    @PutMapping(path = "{id}/formations/{idFormation}")
    public Niveau assignerFormations(@PathVariable Long id,@PathVariable Long idFormation){
        Formation f = fRepository.findById(idFormation).get();
        Niveau n = niveauService.rechercherUnNiveau(id);
        f.setNiveau(n);;
        fRepository.save(f);
        return nRepository.save(n);
    }

    @GetMapping(path = "{id}/formations")
    public List<Formation> afficherFormations(@PathVariable Long id) {
        return niveauService.afficherFormations(id);
    }
    
}
