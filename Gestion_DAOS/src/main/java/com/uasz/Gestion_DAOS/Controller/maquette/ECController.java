package com.uasz.Gestion_DAOS.Controller.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Service.maquette.ECService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class ECController {
    @Autowired
    private ECService ecService;

    @GetMapping("/ec")
    public String lister_ec(Model model){
        List<EC> ecs = ecService.rechercherTousEC();
        model.addAttribute("listeDesECs", ecs);
        return "ec";
    }
    @PostMapping("/ajouter_ec")
    public String ajouter_ec(Model model, EC ec){
        ecService.ajouterEC(ec);
        return "redirect:/ec";
    }


    @PostMapping("/ajouter_ec_ue")
    public String ajouter_ec_ue(Model model, EC ec){
        ecService.ajouterEC(ec);
        log.info("id ue = " + ec.getUe().getIdUE());
        return "redirect:/details_ue?id="+ec.getUe().getIdUE();
    }

    @PostMapping("/modifier_ec_ue")
    public String modifier_ec_ue(Model model, EC ec){
        ecService.modifierEC(ec);
        return "redirect:/details_ue?id="+ec.getUe().getIdUE();
    }

    @PostMapping("/supprimer_ec_ue")
    public String supprimer_ec_ue(Model model, EC ec){
        Long id = ec.getUe().getIdUE();
        ecService.supprimerEC(ec);
        return "redirect:/details_ue?id="+id;
    }

}