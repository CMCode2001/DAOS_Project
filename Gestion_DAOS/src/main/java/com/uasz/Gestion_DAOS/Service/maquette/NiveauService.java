package com.uasz.Gestion_DAOS.Service.maquette;

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

    public void ajouterNiveau(Niveau f){
        nRepository.save(f);
    }

    public List<Niveau> rechercherNiveaus(){
        return nRepository.findAll();
    }

    public Niveau rechercherUnNiveau(Long idNiveau){
        return nRepository.findById(idNiveau).get();
    }

    public Niveau modifierNiveau(Niveau newNiveau, Long idNiveau){
        Niveau niveau = rechercherUnNiveau(idNiveau);
        niveau.setLibelleNiveau(newNiveau.getLibelleNiveau());

        return nRepository.save(niveau);
    }

    public void supprimerNiveau(Long idNiveau){
        nRepository.delete(rechercherUnNiveau(idNiveau));
    }
}
