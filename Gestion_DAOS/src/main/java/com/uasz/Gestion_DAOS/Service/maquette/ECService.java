package com.uasz.Gestion_DAOS.Service.maquette;

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
        ecRepository.save(ec);
    }

    public List<EC> rechercherTousEC(){
        return ecRepository.findAll();
    }

    public EC rechercherEc(Long idEC){
        return ecRepository.findById(idEC).get();
    }

    public EC modifierEC(EC newEC, Long id){
        EC ecModifier = rechercherEc(id);
        ecModifier.setCodeEC(newEC.getCodeEC());
        ecModifier.setLibelleEC(newEC.getLibelleEC());

        return ecRepository.save(ecModifier);
    }
    
    public void supprimerEC(Long idEC){
        ecRepository.deleteById(idEC);
    }
}
