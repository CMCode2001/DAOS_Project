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

import com.uasz.Gestion_DAOS.Modele.maquette.Semestre;
import com.uasz.Gestion_DAOS.Service.maquette.SemestreService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/maquette/semestre")
public class SemestreRestController {
    @Autowired
    private SemestreService semestreService;

    @GetMapping
    public List<Semestre> lister_semestre(){
        return semestreService.rechercherSemestres();
    }

    @GetMapping(path = "/{id}")
    public Semestre rechercher_semestre(@PathVariable Long id){
        return semestreService.rechercherUneSemestre(id);
    }

    @PostMapping
    public Semestre ajouter_semestre(@RequestBody Semestre s){
        return semestreService.ajouter_semestre(s);
    }

    @PutMapping(path = "/{id}")
    public Semestre modifier_Semestre(@PathVariable Long id, @RequestBody Semestre s){
        return semestreService.modifier_semestre(id, s);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_semestre(@PathVariable Long id){
        semestreService.supprimer_semestre(id);
    }
}
