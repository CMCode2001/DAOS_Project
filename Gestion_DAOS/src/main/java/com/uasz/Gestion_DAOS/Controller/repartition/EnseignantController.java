package com.uasz.Gestion_DAOS.Controller.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Service.repartition.EnseignantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantController {
    @Autowired
    private EnseignantService enseignantService;

    @RequestMapping(value = "/enseignant", method = RequestMethod.GET)
    public String listerEnseignant(Model model){
        List<Enseignant> enseignantList = enseignantService.listerToutEnseignant();
        model.addAttribute("listeDesEnseignants", enseignantList);
        return "enseignant";

    }
}
