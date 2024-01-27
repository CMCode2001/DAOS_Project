package com.uasz.Gestion_DAOS.Controller.maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Modele.maquette.Cycle;
import com.uasz.Gestion_DAOS.Modele.maquette.Niveau;
import com.uasz.Gestion_DAOS.Service.maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.maquette.NiveauService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CycleController {
    @Autowired
    private CycleService cycleService;
    @Autowired
    private NiveauService niveauService;

    @GetMapping("/cycle")
    private String lister_cycle(Model model){
        java.util.List<Cycle> cycles = cycleService.rechercheTousCycles();
        model.addAttribute("listeDesCycles", cycles);
        return  "cycle";
    }

    @PostMapping(value = "/ajouter_cycle")
    public String ajouter_cycle(Model model,Cycle cycle){
        cycleService.ajouterCycle(cycle);
        return "redirect:/cycle";
    }

    @PostMapping("/supprimer_cycle")
    public String supprimer_filiere(Model model, Cycle cycle){
        cycleService.supprimerCycle(cycle);
        return "redirect:/cycle";
    }

    @PostMapping("/modifier_cycle")
    public String modifier_cycle(Model model, Cycle cycle){
        cycleService.modifierCycle(cycle);
        return "redirect:/cycle";
    }

    @GetMapping("/details_cycle")
    public String details_cycle(Model model, @RequestParam("id") Long id){
        Cycle c = cycleService.rechercherUnCycle(id);
        java.util.List<Niveau> niveauxList = niveauService.rechercherNiveaux();
        model.addAttribute("cycle", c);
        model.addAttribute("listeDesNiveaux", niveauxList);
        return "cycle_details";
    }
}
