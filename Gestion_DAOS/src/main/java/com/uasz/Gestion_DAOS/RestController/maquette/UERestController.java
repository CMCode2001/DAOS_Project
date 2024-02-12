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

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/ue")
public class UERestController {
    @Autowired
    private UEService ueService;

    @GetMapping 
    public List<UE> lister_ue(){
        return ueService.listerToutUE();
    }

    @GetMapping(path = "/{id}")
    public UE recherche_UE(@PathVariable Long id){
        return ueService.rechercherUE(id);
    }
    
    @PostMapping
    public UE ajouter_ue(@RequestBody UE ue){
        return ueService.ajouter_UE(ue);
    }

    @PutMapping(path = "/{id}")
    public UE modifier_ue(@RequestBody UE ue, @PathVariable Long id){
        return ueService.modifier_UE(ue, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_ue(@PathVariable Long id){
        ueService.supprimer_UE(id);
    }
}