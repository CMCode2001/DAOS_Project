package com.uasz.Gestion_DAOS.Controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Service.maquette.FormationService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class FormationController {
    @Autowired
    private FormationService fService;

    @GetMapping("/formation")
    public String lister_formation(Model model){
        List<Formation> formations = fService.rechercherFormations();
        model.addAttribute("listeDesFormations", formations);
        return "formation";
    }

    @PostMapping("/ajouter_formation")
    public String ajouter_formation(Model model, Formation f){
        fService.ajouterFormation(f);
        return "redirect:/formation";
    }

    @PostMapping("/modifier_formation")
    public String modifier_formation(Model model, Formation f){
        fService.modifierFormation(f);
        return "redirect:/formation";
    }

    @PostMapping("/supprimer_formation")
    public String supprimer_formation(Model model, Formation f){
        fService.supprimerFormation(f);
        return "redirect:/formation";
    }

    @GetMapping("/details_formation")
    public String details_formation(Model model, @RequestParam("id") Long id){
        
        return "formation_details";
    }
}
