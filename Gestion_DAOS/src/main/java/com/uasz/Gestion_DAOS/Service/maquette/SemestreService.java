package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Modele.maquette.Semestre;
import com.uasz.Gestion_DAOS.Repository.maquette.SemestreRepository;

public class SemestreService {
    @Autowired
    private SemestreRepository sRepository;

    public void ajouterSemestre(Semestre s){
        s.setDateCreationSemestre(new Date(System.currentTimeMillis()));
        sRepository.save(s);
    }

    public List<Semestre> rechercherSemestres(){
        return sRepository.findAll();
    }

    public Semestre rechercherUneSemestre(Long idSemestre){
        return sRepository.findById(idSemestre).get();
    }

    public Semestre modifierSemestre(Semestre newSemestre){
        Semestre semestre = rechercherUneSemestre(newSemestre.getIdSemestre());
        semestre.setLibelleSemestre(newSemestre.getLibelleSemestre());
        semestre.setDescriptionSemestre(newSemestre.getDescriptionSemestre());
        return sRepository.save(semestre);
    }

    public void supprimerSemestre(Semestre s){
        sRepository.delete(s);
    }
}
