package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Repository.maquette.ECRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ECService {
    @Autowired
    private ECRepository ecRepository;

    public void ajouterEC(EC ec){
        ec.setDateCreationEC(new Date(System.currentTimeMillis()));
        ecRepository.save(ec);
    }

    public List<EC> rechercherTousEC(){
        return ecRepository.findAll();
    }

    public EC rechercherEc(Long idEC){
        return ecRepository.findById(idEC).get();
    }

    public EC modifierEC(EC newEC){
        EC ecModifier = rechercherEc(newEC.getIdEC());
        ecModifier.setCodeEC(newEC.getCodeEC());
        ecModifier.setLibelleEC(newEC.getLibelleEC());
        ecModifier.setCoefficientEC(newEC.getCoefficientEC());
        ecModifier.setCm(newEC.getCm());
        ecModifier.setTd(newEC.getTd());
        ecModifier.setTp(newEC.getTp());
        ecModifier.setTpe(newEC.getTpe());
        ecModifier.setDescritptionEC(newEC.getDescritptionEC());
        return ecRepository.save(ecModifier);
    }
    
    public void supprimerEC(EC ec){
        ecRepository.delete(ec);
    }
}
