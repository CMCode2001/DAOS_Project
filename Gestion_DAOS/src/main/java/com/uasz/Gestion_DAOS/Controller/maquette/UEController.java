package com.uasz.Gestion_DAOS.Controller.maquette;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Service.maquette.UEService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UEController {
    @Autowired
    private UEService ueService;

   @RequestMapping(value = "/ue", method = RequestMethod.GET)
    public String lister_ue(Model model){
       List<UE> ueList = ueService.listerToutUE();
       model.addAttribute("listeDesUE", ueList);
       return "ue";
   }

   @RequestMapping(value = "/ajouter_ue", method = RequestMethod.POST)
    public String ajouter_ue(Model model, UE ue){
       ueService.ajouterUE(ue);
       return "redirect:/ue";
   }





}
