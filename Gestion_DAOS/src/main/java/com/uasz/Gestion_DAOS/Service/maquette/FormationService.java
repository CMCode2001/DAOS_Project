package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Repository.maquette.FormationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FormationService {
    @Autowired
    private FormationRepository fRepository;

    public void ajouterFormation(Formation f){
        fRepository.save(f);
    }

    public List<Formation> rechercherFormations(){
        return fRepository.findAll();
    }

    public Formation rechercherUneFormation(Long idFil){
        return fRepository.findById(idFil).get();
    }

    public Formation modifierFormation(Formation newFormation, Long idFil){
        Formation f = rechercherUneFormation(idFil);
        f.setLibelleFormation(newFormation.getLibelleFormation());
        f.setDescriptionFormation(newFormation.getDescriptionFormation());
        return fRepository.save(f);
    }

    public void supprimerFormation(Long idFil){
        fRepository.delete(rechercherUneFormation(idFil));
    }
}
