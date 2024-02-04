package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
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
        f.setDateCreationFormation(new Date(System.currentTimeMillis()));
        fRepository.save(f);
    }

    public List<Formation> rechercherFormations(){
        return fRepository.findAll();
    }

    public Formation rechercherUneFormation(Long idFil){
        return fRepository.findById(idFil).get();
    }

    public Formation modifierFormation(Formation newFormation){
        Formation f = rechercherUneFormation(newFormation.getIdFormation());
        f.setLibelleFormation(newFormation.getLibelleFormation());
        f.setDescriptionFormation(newFormation.getDescriptionFormation());
        return fRepository.save(f);
    }

    public void supprimerFormation(Formation f){
        fRepository.delete(f);
    }

    public Formation ajouter_formation( Formation f){
        f.setDateCreationFormation(new Date(System.currentTimeMillis()));
        return fRepository.save(f);
    }

    public Formation modifier_formation(Formation f, Long id){
        f.setIdFormation(id);
        return fRepository.save(f);
    }

    public void supprimer_formation(Long id){
        fRepository.deleteById(id);
    }
}
