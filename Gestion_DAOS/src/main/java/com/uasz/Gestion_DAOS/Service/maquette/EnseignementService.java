package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Repository.maquette.EnseignementRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EnseignementService {
    @Autowired
    private EnseignementRepository eRepository;

    public void ajouterEnseignement(Enseignement ens){
        ens.setDateCreationEnseignement(new Date(System.currentTimeMillis()));
        eRepository.save(ens);
    }

    public List<Enseignement> rechercherEnseignements(){
        return eRepository.findAll();
    }

    public Enseignement rechercherUneEnseignement(Long idEns){
        return eRepository.findById(idEns).get();
    }

    public Enseignement modifierEnseignement(Enseignement ens){
        Enseignement e = rechercherUneEnseignement(ens.getIdEnseignement());
        e.setObjectifsEnseignement(ens.getObjectifsEnseignement());
        e.setDescriptionEnseignements(ens.getDescriptionEnseignements());
        return eRepository.save(e);
    }

    public void supprimerEnseignement(Enseignement ens){
        eRepository.delete(ens);
    }
}
