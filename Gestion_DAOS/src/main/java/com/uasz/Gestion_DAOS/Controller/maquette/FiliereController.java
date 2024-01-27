package com.uasz.Gestion_DAOS.Controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Modele.maquette.Filiere;
import com.uasz.Gestion_DAOS.Service.maquette.FiliereService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class FiliereController {
    @Autowired
    private FiliereService fService;

    @GetMapping("/filiere")
    public String lister_filiere(Model model){
        List<Filiere> filieres = fService.rechercherFilieres();
        model.addAttribute("listeDesFilieres", filieres);
        return "filiere";
    }

    @PostMapping("/ajouter_filiere")
    public String ajouter_filiere(Model model, Filiere f){
        fService.ajouterFiliere(f);
        return "redirect:/filiere";
    }

    @PostMapping("/modifier_filiere")
    public String modifier_filiere(Model model, Filiere f){
        fService.modifierFiliere(f);
        return "redirect:/filiere";
    }

    @PostMapping("/supprimer_filiere")
    public String supprimer_filiere(Model model, Filiere f){
        fService.supprimerFiliere(f);
        return "redirect:/filiere";
    }

    @GetMapping("/details_filiere")
    public String details_filiere(Model model, @RequestParam("id") Long id){
        
        return "Filiere_details";
    }
}
