package com.uasz.Gestion_DAOS.Controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UEController {
    @Autowired
    private UEService ueService;

    @GetMapping("/ue")
    public String lister_ue(Model model){
        List<UE> ueList = ueService.listerToutUE();
        model.addAttribute("listeDesUE", ueList);
        return  "ue";
    }


    @PostMapping(value = "/ajouter_ue")
    public String ajouter_ue(Model model, UE ue){
        ueService.ajouterUE(ue);
        return "redirect:/ue";
    }

    @PostMapping("/modifier_ue")
    public String modifier_ue(UE ue, Model model) {
        ueService.modifierUE(ue); 
        return "redirect:/ue";
    }

    @PostMapping("/supprimer_ue")
    public String supprimer_ue(UE ue, Model model){
        ueService.supprimerUE(ue);
        return "redirect:/ue";   
    }

    @GetMapping("/details_ue")
    public String details_ue(Model model, @RequestParam("id") Long id){
        UE ue = ueService.rechercherUE(id);
        List<EC> ecList = ueService.afficherLesECs(ue);
        model.addAttribute("ue", ue);
        model.addAttribute("listeDesEC", ecList);
        return "ue_details";
    }

    
}
