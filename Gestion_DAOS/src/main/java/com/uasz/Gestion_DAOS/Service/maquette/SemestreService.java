package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Modele.maquette.Semestre;
import com.uasz.Gestion_DAOS.Repository.maquette.SemestreRepository;

public class SemestreService {
    @Autowired
    private SemestreRepository sRepository;

    public void ajouterSemestre(Semestre f){
        sRepository.save(f);
    }

    public List<Semestre> rechercherSemestres(){
        return sRepository.findAll();
    }

    public Semestre rechercherUneSemestre(Long idSemestre){
        return sRepository.findById(idSemestre).get();
    }

    public Semestre modifierSemestre(Semestre newSemestre, Long idSemestre){
        Semestre semestre = rechercherUneSemestre(idSemestre);
        semestre.setNumeroSemestre(newSemestre.getNumeroSemestre());
        return sRepository.save(semestre);
    }

    public void supprimerSemestre(Long idSemestre){
        sRepository.delete(rechercherUneSemestre(idSemestre));
    }
}
