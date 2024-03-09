package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Modele.emploi.Deroulement;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Repository.emploi.DeroulementRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Transactional
@AllArgsConstructor
public class DeroulementService {
    @Autowired
    private DeroulementRepository deroulementRepository;

    //AJOUTER 
    public Deroulement ajouter_Deroulement(Deroulement deroulement){
        Deroulement savedDeroulement = deroulementRepository.save(deroulement);
        savedDeroulement.setDateCreationDeroulement(new Date(System.currentTimeMillis()));
        return deroulementRepository.save(savedDeroulement);
    }

    //MODIFIER
    public Deroulement modifier_Deroulement(Deroulement Deroulement, Long idDer){
        Deroulement.setIdDeroulement(idDer);
        return deroulementRepository.save(Deroulement);
    }

    //RECHERCHER
    public Deroulement recherche_Deroulement(Long idDer) {
      return deroulementRepository.findById(idDer).get();
    }
    //SUPPRIMER
    public void supprimer_Deroulement(Long idDer){
        deroulementRepository.deleteById(idDer);
    }

    //LISTER TOUT ATTRIBUT
    public List<Deroulement> listerToutDeroulement() {
       return deroulementRepository.findAll();
    }

    public Seance afficherSeance(Long id){
        Deroulement d = recherche_Deroulement(id);
        return d.getSeance();
    }
}
