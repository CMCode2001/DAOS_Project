package com.uasz.Gestion_DAOS.RestController.maquette;

import  java.util.List;

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

import com.uasz.Gestion_DAOS.Modele.maquette.Cycle;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Modele.maquette.Niveau;
import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Repository.maquette.CycleRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.NiveauRepository;
import com.uasz.Gestion_DAOS.Service.maquette.CycleService;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/cycle")
public class CycleRestController {
    @Autowired
    private CycleService cService;

    @Autowired
    private CycleRepository cRepository;

    @Autowired
    private NiveauRepository nRepository;

    @GetMapping
    private List<Cycle> lister_cycle(){
        return cService.rechercheTousCycles();
    }

    @GetMapping(path = "/{id}")
    private Cycle rechercher_cycle(@PathVariable Long id){
        return cService.rechercherUnCycle(id);
    }

    @PostMapping
    public Cycle ajouter_cycle(@RequestBody Cycle c){
        return cService.ajouter_cycle(c);
    }

    @PutMapping(path = "/{id}")
    public Cycle modifier_cycle(@PathVariable Long id, @RequestBody Cycle c){
        return cService.modifier_cycle(id, c);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_cycle(@PathVariable Long id){
        cService.supprimer_cycle(id);
    }

    @PutMapping(path = "{id}/niveau/{idNiveau}")
    public Cycle assigner_Repartition(@PathVariable Long id,@PathVariable Long idNiveau){
        Niveau n = nRepository.findById(idNiveau).get();
        Cycle c = cService.rechercherUnCycle(id);
        n.setCycle(c);
        nRepository.save(n);
        return cRepository.save(c);
    }

    @GetMapping(path = "{id}/niveau")
    public List<Niveau> afficherNiveaux(@PathVariable Long id) {
        return cService.afiicherNiveaux(id);
    }
    
}
