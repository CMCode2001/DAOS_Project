package com.uasz.Gestion_DAOS.Controller.emploi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Service.emploi.BatimentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class BatimentController {
    @Autowired
    private BatimentService batimentService;

    @RequestMapping(value = "/batiment", method = RequestMethod.GET)
    public String listerBat(Model model){
        List<Batiment> batimentList = batimentService.listerToutBatiment();
        model.addAttribute("listeDesBatiments", batimentList);
        return "batiment";
    }

    @RequestMapping(value = "/ajouter_batiment", method = RequestMethod.POST)
    public String ajouterBat(Model model, Batiment batiment){
        batimentService.ajouterVac(batiment);
        return "redirect:/batiment";
    }
}
