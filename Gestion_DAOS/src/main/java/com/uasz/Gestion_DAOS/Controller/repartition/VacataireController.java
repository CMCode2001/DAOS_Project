package com.uasz.Gestion_DAOS.Controller.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Service.repartition.VacataireService;
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
@NoArgsConstructor
@AllArgsConstructor
public class VacataireController {
    @Autowired
    private VacataireService vacataireService;

    @RequestMapping(value = "/vacataire", method = RequestMethod.GET)
    public String listerPer(Model model){
        List<Vacataire> vacataireList = vacataireService.lister_vacataires();
        model.addAttribute("listeDesVacataires", vacataireList);
        return "vacataire";
    }

    @RequestMapping(value = "/ajouter_vacataire", method = RequestMethod.POST)
    public String ajouterPer(Model model, Vacataire vacataire){
        vacataireService.ajouter_vacataire(vacataire);
        return "redirect:/vacataire";
    }
    @GetMapping(value="/deleteVac/{id}")
    public String deletePER (@PathVariable Long id){
        vacataireService.supprimer_vacataire(id );
        return "redirect:/vacataire";
    }
}
