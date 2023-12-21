package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;
import java.util.Optional;

import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Repository.maquette.UERepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@Transactional
@Data
public class UEService {
    @Autowired
    private UERepository ueRepository;

    /**
     *  Methode ajouter d'un Unite d'enseignement(UE)
     * @param ue
     * @return UE
     */
    public UE ajouterUE(UE ue){
        ueRepository.save(ue);
        return  ue;
    }

    /**
     * Methode permettant de lister tous les UE
     * @return {@code List<UE>}
     */
    public List<UE> listerToutUE(){
        return ueRepository.findAll();
    }

    /**
     * Methode permettant de trouver un UE de par son ID
     * @param idUE
     * @return {@code Optional} contenant l'UE trouve, ou {@code Optional.empty()} si aucun UE est trouve;
     */
    public Optional<UE> rechercherUE(Long idUE){
        return ueRepository.findById(idUE);
    }

    /**
     * Methode permettant de modifier un UE
     * @param ue
     * @return {@Code UE} la nouvelle UE modifier ou, {@code new RuntimeException()} si l'UE n'existe pas
     */
    public UE modifierUE(UE ue){
        Optional<UE> ueModifier = rechercherUE(ue.getIdUE());
        if(ueModifier.isPresent()) {
            ueModifier.orElseThrow().setLibelleUE(ue.getLibelleUE());
            ueModifier.orElseThrow().setCodeUE(ue.getCodeUE());
            ueModifier.orElseThrow().setDescriptionUE(ue.getDescriptionUE());
            return ueRepository.save(ueModifier.get());
        }
        else{
            // Gérer le cas où l'UE n'est pas trouvée
            throw new RuntimeException("UE non trouvée avec l'ID : " + ue.getIdUE());
        }

    }

    /**
     * Methode permettant de supprimer un UE;
     * @param ue
     */
    public void supprimerUE(UE ue){
        Optional<UE> deletedUE = rechercherUE(ue.getIdUE());
        if (deletedUE.isPresent()){
            ueRepository.delete(deletedUE.get());
        }else {
            new RuntimeException("UE introuvable !!!");
        }

    }



}
