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
import com.uasz.Gestion_DAOS.Service.maquette.MaquetteService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/maquette")
public class MaquetteRestController {
    @Autowired
    private MaquetteService maquetteService;

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
}
