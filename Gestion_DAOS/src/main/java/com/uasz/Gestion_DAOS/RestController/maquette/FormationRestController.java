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
import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Modele.maquette.Maquette;
import com.uasz.Gestion_DAOS.Repository.maquette.ClasseRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.FormationRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.MaquetteRepository;
import com.uasz.Gestion_DAOS.Service.maquette.FormationService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/formation")
public class FormationRestController {
    @Autowired
    private FormationService formationService;

    @Autowired
    private ClasseRepository cRepository;

    @Autowired
    private FormationRepository fRepository;

    @Autowired
    private MaquetteRepository mRepository;

    @GetMapping
    private List<Formation> lister_formation(){
        return formationService.rechercherFormations();
    }

    @GetMapping(path = "/{id}")
    private Formation rechercher_formation(@PathVariable Long id){
        return formationService.rechercherUneFormation(id);
    }

    @PostMapping
    public Formation ajouter_formation(@RequestBody Formation c){
        return formationService.ajouter_formation(c);
    }

    @PutMapping(path = "/{id}")
    public Formation modifier_formation(@PathVariable Long id, @RequestBody Formation c){
        return formationService.modifier_formation( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_formation(@PathVariable Long id){
        formationService.supprimer_formation(id);
    }

    @PutMapping(path = "{id}/classes/{idClasse}")
    public Formation assigner_Classe(@PathVariable Long id,@PathVariable Long idClasse){
        Classe c = cRepository.findById(idClasse).get();
        Formation f = formationService.rechercherUneFormation(id);
        c.setFormation(f);
        cRepository.save(c);
        return fRepository.save(f);
    }

    @PutMapping(path = "{id}/maquette/{idMaquette}")
    public Formation assigner_Maquette(@PathVariable Long id,@PathVariable Long idMaquette){
        Maquette m = mRepository.findById(idMaquette).get();
        Formation f = formationService.rechercherUneFormation(id);
        m.setFormation(f);
        mRepository.save(m);
        return fRepository.save(f);
    }

    @GetMapping(path = "{id}/classes")
    public List<Classe> assignerClasses(@PathVariable Long id){
        return formationService.afficherClasses(id);
    }

    @GetMapping(path = "{id}/maquette")
    public Maquette assignerMaquette(@PathVariable Long id){
        return formationService.afficherMaquette(id);
    }


}
