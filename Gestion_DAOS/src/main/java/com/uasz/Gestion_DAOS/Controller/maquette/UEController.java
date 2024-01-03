package com.uasz.Gestion_DAOS.Controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Repository.maquette.UERepository;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UEController {
    @Autowired
    private UEService ueService;
    @Autowired
    private UERepository ueRepository;

    @GetMapping("/ue")
    public String lister_ue(Model model){
        List<UE> ueList = ueService.listerToutUE();
        model.addAttribute("listeDesUE", ueList);
        return  "ue";
    }

    @GetMapping("/supprimer")
    public String supprimerUnUE(Long id){
        ueService.supprimerUE(ueService.rechercherUE(id).get());
        return "redirect:/ue";
    }

    @PostMapping(value = "/ajouter_ue")
    public String ajouter_ue(Model model, UE ue){
        ueService.ajouterUE(ue);
        return "redirect:/ue";
    }


//    @PostMapping(value = "/modifier_ue")
//    public String modifier_ue(Long id){
//        ueService.modifierUE(ueService.rechercherUE(id).get());

    

    @GetMapping("/modifier_ue")
    public String modifier(Long id, Model model) {
        UE ue = ueService.modifierUE(ueService.rechercherUE(id).get()); 
        model.addAttribute("ue", ue);

        return "redirect:/ue";
    }

    @PostMapping("/editer")
    public String editer(Model model, UE ue){
        
        return "redirect:/ue";
    }
    



}