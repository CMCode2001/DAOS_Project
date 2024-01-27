package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Niveau;
import com.uasz.Gestion_DAOS.Repository.maquette.NiveauRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class NiveauService {
    @Autowired
    private NiveauRepository nRepository;

    public void ajouterNiveau(Niveau n){
        n.setDateCreationNiveau(new Date(System.currentTimeMillis()));
        nRepository.save(n);
    }

    public List<Niveau> rechercherNiveaux(){
        return nRepository.findAll();
    }

    public Niveau rechercherUnNiveau(Long idNiveau){
        return nRepository.findById(idNiveau).get();
    }

    public Niveau modifierNiveau(Niveau newNiveau){
        Niveau niveau = rechercherUnNiveau(newNiveau.getIdNiveau());
        niveau.setLibelleNiveau(newNiveau.getLibelleNiveau());
        niveau.setDescriptionNiveau(newNiveau.getDescriptionNiveau());
        return nRepository.save(niveau);
    }

    public void supprimerNiveau(Niveau n){
        nRepository.delete(n);
    }
}
