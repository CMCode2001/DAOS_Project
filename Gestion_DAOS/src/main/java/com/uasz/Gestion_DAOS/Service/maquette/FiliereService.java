package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Filiere;
import com.uasz.Gestion_DAOS.Repository.maquette.FiliereRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FiliereService {
    @Autowired
    private FiliereRepository fRepository;

    public void ajouterFiliere(Filiere f){
        fRepository.save(f);
    }

    public List<Filiere> rechercherFilieres(){
        return fRepository.findAll();
    }

    public Filiere rechercherUneFiliere(Long idFil){
        return fRepository.findById(idFil).get();
    }

    public Filiere modifierFiliere(Filiere newFiliere, Long idFil){
        Filiere f = rechercherUneFiliere(idFil);
        f.setNomFiliere(newFiliere.getNomFiliere());
        return fRepository.save(f);
    }

    public void supprimerFiliere(Long idFil){
        fRepository.delete(rechercherUneFiliere(idFil));
    }
}