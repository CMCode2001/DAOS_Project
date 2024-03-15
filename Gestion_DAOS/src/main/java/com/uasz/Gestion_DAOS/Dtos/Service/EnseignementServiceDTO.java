package com.uasz.Gestion_DAOS.Dtos.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Dtos.Model.EnseignementDTO;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Service.maquette.EnseignementService;

@Service
public class EnseignementServiceDTO {
    
     @Autowired
    private EnseignementService enseignementService;

    public List<EnseignementDTO> lister_EnseignementDTO(){
        List<Enseignement> enseignements = enseignementService.rechercherEnseignements();
        List<EnseignementDTO> enseignementDTOs = new ArrayList<>();
        for (int i = 0; i < enseignements.size(); i++) {
            EnseignementDTO enseignementDTO = new EnseignementDTO();
            enseignementDTO.setId(enseignements.get(i).getIdEnseignement());
            enseignementDTO.setLibelle(enseignements.get(i).getLibelleEnseignement());
            enseignementDTO.setDescription(enseignements.get(i).getDescriptionEnseignement());
            enseignementDTO.setIdModule(enseignements.get(i).getModule().getIdModule());
            enseignementDTO.setCours(enseignements.get(i).getModule().getCoursModule());
            enseignementDTO.setCoefficient(enseignements.get(i).getModule().getCoefficientModule());
            enseignementDTO.setNbreHeure(enseignements.get(i).getModule().getDureeModule());
            enseignementDTO.setIdClasse(enseignements.get(i).getClasse().getIdClasse());
            enseignementDTO.setClasse(enseignements.get(i).getClasse().getLibelleClasse());

            if (enseignements.get(i).getGroupe() != null) {
                enseignementDTO.setIdGroupe(enseignements.get(i).getGroupe().getIdGroupe());
                enseignementDTO.setGroupe(enseignements.get(i).getGroupe().getLibelleGroupe());
                
            }

            enseignementDTO.setSemestre(enseignements.get(i).getClasse().getSemestre().getLibelleSemestre());
            enseignementDTOs.add(enseignementDTO);

        } 
        
        return enseignementDTOs;
    }

}
