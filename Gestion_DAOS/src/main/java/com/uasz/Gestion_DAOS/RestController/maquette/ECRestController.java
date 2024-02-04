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

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Service.maquette.ECService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/ec")
public class ECRestController {
    @Autowired
    private ECService ecService;

    @GetMapping
    public List<EC> lister_ec(){
        return ecService.rechercherTousEC();
    } 

    @GetMapping(path = "/{id}")
    public EC recherche_ec(@PathVariable Long id){
        return ecService.rechercherEc(id);
    }

    @PostMapping
    public EC ajouter_ec(@RequestBody EC ec){
        return ecService.ajouter_ec(ec);
    }

    @PutMapping(path = "/{id}")
    public EC modifier_ec(@PathVariable Long id, @RequestBody EC ec){
        return ecService.modifier_ec(ec, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_ec(@PathVariable Long id ){
        ecService.supprimer_ec(id);
    }
}

