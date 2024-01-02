package com.uasz.Gestion_DAOS.Controller.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Service.repartition.PerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class PerController {
    @Autowired
    private PerService perService;

    @RequestMapping(value = "/per", method = RequestMethod.GET)
    public String listerPer(Model model){
        List<PER> persList = perService.listerToutPER();
        model.addAttribute("listeDesPERS", persList);
        return "per";
    }

    @RequestMapping(value = "/ajouter_per", method = RequestMethod.POST)
    public String ajouterPer(Model model, PER per){
        perService.ajouterPer(per);
        return "redirect:/per";
    }
    @GetMapping(value="/delete/{id}")
    public String deletePER (@PathVariable Long matriculePer){
        perService.deletePer(matriculePer);
        return "redirect:/per";
    }
}
