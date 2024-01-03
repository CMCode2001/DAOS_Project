package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Classe;
import com.uasz.Gestion_DAOS.Repository.maquette.ClasseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasseService {
    @Autowired
    private ClasseRepository cRepository;

    public Classe ajouterClasse(Classe c) {
        Classe classe = cRepository.save(c);
        return classe;
    }

    public List<Classe> rechercherLesClasses(){
        List<Classe> classes = cRepository.findAll();
        return classes; 
    }

    public Classe rechercherUneClasse(Long idClasse){
        Classe classe = cRepository.findById(idClasse).get();
        return classe;
    }

    public Classe modifierClasse(Classe classe){
        Classe cModifier = rechercherUneClasse(classe.getIdClasse());
        cModifier.setEffectifClasse(classe.getEffectifClasse());
        cModifier.setLibelleClasse(classe.getLibelleClasse());
        return cRepository.save(cModifier);
    }

    public void supprimerClasse(Long idClasse){
        Classe cDeleted = rechercherUneClasse(idClasse);
        cRepository.delete(cDeleted);
    }
    
}
