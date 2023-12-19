package com.uasz.Gestion_DAOS.Service.maquette;

import com.uasz.Gestion_DAOS.Repository.maquette.UERepository;
import com.uasz.Gestion_DAOS.maquette.modele.UE;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
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
     * @return
     */
    public Iterable<UE> listerToutUE(){
        return ueRepository.findAll();
    }

    /**
     * Methode permettant de trouver un UE de par son ID
     * @param idUE
     * @return
     */
    public Optional<UE> rechercherUE(Long idUE){
        return ueRepository.findById(idUE);
    }

    public UE modifierUE(UE ue){
        Optional<UE> ueModifier = rechercherUE(ue.getIdUE());
        if(ueModifier.isPresent()) {
            ueModifier.orElseThrow().setLibelleUE(ue.getLibelleUE());
            ueModifier.orElseThrow().setCodeUE(ue.getCodeUE());
            ueModifier.orElseThrow().setDescriptionUE(ue.getDescriptionUE());
            ueRepository.save(ue);
        }
        return null;
    }


}
