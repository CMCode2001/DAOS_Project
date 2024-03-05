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
import com.uasz.Gestion_DAOS.Service.maquette.ClasseService;


@RestController
@RequestMapping(path = "/maquette/classe")
public class ClasseRestController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    private List<Classe> lister_classe(){
        return classeService.rechercherLesClasses();
    }

    @GetMapping(path = "/{id}")
    private Classe rechercher_classe(@PathVariable Long id){
        return classeService.rechercherUneClasse(id);
    }

    @PostMapping
    public Classe ajouter_classe(@RequestBody Classe c){
        return classeService.ajouter_classe(c);
    }

    @PutMapping(path = "/{id}")
    public Classe modifier_classe(@PathVariable Long id, @RequestBody Classe c){
        return classeService.modifier_classe(id, c);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_classe(@PathVariable Long id){
        classeService.supprimer_classe(id);
    }
}
