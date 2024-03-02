package com.uasz.Gestion_DAOS.RestController.repartition;

import java.util.Date;
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

import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Service.repartition.PerService;


@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/repartition/per")
public class PERRestController {

    @Autowired
    private PerService perService;

    @GetMapping
    private List<PER> lister_per(){
        return perService.listerToutPER();
    }

    @GetMapping(path = "/{id}")
    private PER rechercher_per(@PathVariable Long id){
        return perService.searchPer(id);
    }

    @PostMapping
    public PER ajouter_per(@RequestBody PER c){
        return perService.ajouterPer(c);
    }

    @PutMapping(path = "/{id}")
    public PER modifier_per(@PathVariable Long id, @RequestBody PER c){
        return perService.modifier_per(c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_per(@PathVariable Long id){
        perService.deletePer(id);
    }
    
}
