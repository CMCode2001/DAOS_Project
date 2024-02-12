package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Repository.emploi.BatimentRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Transactional
@Data
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    /**
     *  Methode ajouter un Batiment
     * @param batiment
     * @return batiment
     */
    public Batiment ajouterBat(Batiment batiment){
        batiment.setDateCreationBatiment(new Date(System.currentTimeMillis()));
        return batimentRepository.save(batiment);

    }

    /**
     * Methode permettant de lister tous les Batiments
     * @return {@code List<Batiment>}
     */
    public List<Batiment> listerToutBatiment(){
        return batimentRepository.findAll();
    }

    /**
     * Methode permettant de trouver un Batiment de par son ID
     * @param idBatiment
     * @return {@code Optional} contenant le Batiment trouve, ou {@code Optional.empty()} si aucun Batiment est trouve;
     */
    public Optional<Batiment> searchVac(Long idBatiment){
        return batimentRepository.findById(idBatiment);
    }

    /**
     * Methode permettant de modifier un Batiment
     * @param batiment
     * @return {@Code Batiment} la nouvelle Batiment modifier ou, {@code new RuntimeException()} si le Batiment n'existe pas
     */
    public Batiment modifierBat(Batiment batiment){
        Batiment batModif = searchVac(batiment.getIdBatiment()).get();
        batModif.setCodeBatiment(batiment.getCodeBatiment());
        batModif.setLibelleBatiment(batiment.getLibelleBatiment());
        batModif.setPositionBatiment(batiment.getPositionBatiment());
        batModif.setDescriptionBatiment(batiment.getDescriptionBatiment());
        return batimentRepository.save(batModif);
    }
    // 
    public Batiment modifier_Batiment(Batiment batiment, Long idBat){
        batiment.setIdBatiment(idBat);
        return batimentRepository.save(batiment);
    }
    // 
    /**
     * Methode permettant de supprimer un Batiment;
     *
     * @param idBatiment
     * @return
     */


    public void deleteBat(Batiment batiment){
        batimentRepository.delete(batiment);
    }

    public void supprimer_Batiment(Long idBat){
        batimentRepository.deleteById(idBat);
    }
    
    public Batiment ajouter_Batiment(Batiment batiment){
        Batiment savedBat = batimentRepository.save(batiment);
        savedBat.setDateCreationBatiment(new Date(System.currentTimeMillis()));
        return batimentRepository.save(savedBat);
    }

    public Batiment recherche_Batiment(Long idBat) {
      return batimentRepository.findById(idBat).get();
    }
}
