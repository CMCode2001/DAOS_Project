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

@Controller
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

    @GetMapping("/supprimer_ec")
    public String supprimer_ec(Long id){
        ecService.supprimerEC(id);
        return "redirect:/ec";
    }

    @PostMapping("/ajouter_ec")
    public String ajouter_ec(Model model, EC ec){
        ecService.ajouterEC(ec);
        return "redirect:/ec";
    }

    @GetMapping("/formEC")
    public String formEC(Model model){
        model.addAttribute("ec", new EC());
        return "formEC";
    }

}
