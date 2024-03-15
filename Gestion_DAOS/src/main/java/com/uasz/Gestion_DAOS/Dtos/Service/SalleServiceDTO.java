package com.uasz.Gestion_DAOS.Dtos.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Dtos.Model.SalleDTO;
import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Service.emploi.SalleService;

@Service
public class SalleServiceDTO {
    @Autowired
    private SalleService salleService;

    public List<SalleDTO> lister_SalleDTOs(){
        List<Salle> salles = salleService.listerToutSalle();
        List<SalleDTO> salleDTOs = new ArrayList<>();
        for (int i = 0; i < salles.size(); i++) {
            SalleDTO salle = new SalleDTO();
            salle.setIdSalle(salles.get(i).getIdSalle());
            salle.setSalle(salles.get(i).getLibelleSalle());
            salle.setCodeSalle(salles.get(i).getCodeSalle());
            salle.setCapacite(salles.get(i).getCapaciteSalle());
            if( salles.get(i).getBatiment() != null){
                salle.setIdBatiment(salles.get(i).getBatiment().getIdBatiment());
                salle.setBatiment(salles.get(i).getBatiment().getLibelleBatiment());
                salle.setPosition(salles.get(i).getBatiment().getPositionBatiment());    
            }

            salleDTOs.add(salle);
        }

        return salleDTOs;
    }
    
}
