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

import com.uasz.Gestion_DAOS.Modele.maquette.Maquette;
import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Repository.maquette.FormationRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.MaquetteRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.ModuleRepository;
import com.uasz.Gestion_DAOS.Service.maquette.MaquetteService;
import com.uasz.Gestion_DAOS.Modele.maquette.Module;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/maquette")
public class MaquetteRestController {
    @Autowired
    private MaquetteService maquetteService;

    @Autowired
    private FormationRepository fRepository;

    @Autowired 
    private MaquetteRepository mRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping
    private List<Maquette> lister_maquette(){
        return maquetteService.rechercherMaquettes();
    }

    @GetMapping(path = "/{id}")
    private Maquette rechercher_maquette(@PathVariable Long id){
        return maquetteService.rechercherUneMaquette(id);
    }

    @PostMapping
    public Maquette ajouter_maquette(@RequestBody Maquette c){
        return maquetteService.ajouter_maquette(c);
    }

    @PutMapping(path = "/{id}")
    public Maquette modifier_maquette(@PathVariable Long id, @RequestBody Maquette c){
        return maquetteService.modifier_maquette( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_maquette(@PathVariable Long id){
        maquetteService.supprimer_maquette(id);
    }

    @PutMapping(path = "{id}/formation/{idFormation}")
    public Maquette assigner_Formation(@PathVariable Long id,@PathVariable Long idFormation){
        Formation f = fRepository.findById(idFormation).get();
        Maquette m = maquetteService.rechercherUneMaquette(id);
        m.setFormation(f);
        fRepository.save(f);
        return  mRepository.save(m);
    }

    @PutMapping(path = "{id}/modules/{idModule}")
    public Maquette ajouter_Module_Maquette(@PathVariable Long id,@PathVariable Long idModule){
        Module m = moduleRepository.findById(idModule).get();
        Maquette maquette = maquetteService.rechercherUneMaquette(id);
        m.setMaquette(maquette);
        moduleRepository.save(m);
        return mRepository.save(maquette);
    }

    @GetMapping(path = "{id}/modules")
    public List<Module> affichModules(@PathVariable Long id) {
        return maquetteService.afficherModules(id);
    }
    
    @GetMapping(path = "{id}/formation")
    public Formation afficherFormation(@PathVariable Long id) {
        return maquetteService.afficherFormation(id);
    }
}
