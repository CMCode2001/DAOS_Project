package com.uasz.Gestion_DAOS.Service.maquette;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Repository.maquette.UERepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class UEService {
    @Autowired
    private UERepository ueRepository;

    public void ajouterUE(UE ue){
        UE savedUE = ueRepository.save(ue);
        savedUE.setDateCreationUE(new Date(System.currentTimeMillis()));
        ueRepository.save(savedUE);
    }

    public List<UE> listerToutUE(){
        return ueRepository.findAll();
    }

    public UE rechercherUE(Long idUE){
        return ueRepository.findById(idUE).get();
    }

    public UE modifierUE(UE ue){
        UE ueModifier = rechercherUE(ue.getIdUE());
        ueModifier.setLibelleUE(ue.getLibelleUE());
        ueModifier.setCodeUE(ue.getCodeUE());
        ueModifier.setCoefficientUE(ue.getCoefficientUE());
        ueModifier.setCreditUE(ue.getCreditUE());
        ueModifier.setCreditUE(ue.getCreditUE());
        ueModifier.setDescriptionUE(ue.getDescriptionUE());
        return ueRepository.save(ueModifier);
    }

    public void supprimerUE(UE ue){
        ueRepository.delete(ue);
    }

    public List<EC> afficherLesECs(UE ue){
        return ueRepository.findByUE(ue);
    }
    


}