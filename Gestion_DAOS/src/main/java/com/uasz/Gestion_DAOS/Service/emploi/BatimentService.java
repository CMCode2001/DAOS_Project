package com.uasz.Gestion_DAOS.Service.emploi;

import com.uasz.Gestion_DAOS.Modele.emploi.Batiment;
import com.uasz.Gestion_DAOS.Repository.emploi.BatimentRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Batiment ajouterVac(Batiment batiment){
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
        Optional<Batiment> batModif = searchVac(batiment.getIdBatiment());
        if(batModif.isPresent()) {
            batModif.orElseThrow().setIdBatiment(batiment.getIdBatiment());
            batModif.orElseThrow().setNomBatiment(batiment.getNomBatiment());
            batModif.orElseThrow().setAnneeBatiment(batiment.getAnneeBatiment());
            batModif.orElseThrow().setTypeBatiment(batiment.getTypeBatiment());
            batModif.orElseThrow().setNb_Etage(batiment.getNb_Etage());
            return batimentRepository.save(batModif.get());
        }
        else{
            // Gérer le cas où le Batiment n'est pas trouvée
            throw new RuntimeException("Batiment non trouvée avec l'ID : " + batiment.getIdBatiment());
        }

    }
    /**
     * Methode permettant de supprimer un Batiment;
     *
     * @param idBatiment
     * @return
     */
    public void deleteBat(Long idBatiment){
        batimentRepository.deleteById(idBatiment);
    }
}
