package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Classe;
import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Modele.maquette.Groupe;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Repository.maquette.ClasseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasseService {
    @Autowired
    private ClasseRepository cRepository;

    @Autowired
    private GroupeService gService;

    public void ajouterClasse(Classe c) {
        c.setDateCreationClasse(new Date(System.currentTimeMillis()));
        cRepository.save(c);
    }

    public List<Classe> rechercherLesClasses(){
        return cRepository.findAll();
    }

    public Classe rechercherUneClasse(Long idClasse){ 
        return cRepository.findById(idClasse).get();
    }

    public Classe modifierClasse(Classe classe){
        Classe cModifier = rechercherUneClasse(classe.getIdClasse());
        cModifier.setLibelleClasse(classe.getLibelleClasse());
        cModifier.setEffectifClasse(classe.getEffectifClasse());
        cModifier.setNbreGroupeClasse(classe.getNbreGroupeClasse());
        cModifier.setDescriptionClasse(classe.getDescriptionClasse());
        return cRepository.save(cModifier);
    }

    public void supprimerClasse(Classe c){
        cRepository.delete(c);
    }

    public Classe ajouter_classe(Classe c){
        c.setDateCreationClasse(new Date(System.currentTimeMillis()));
        return cRepository.save(c);
    }
    
    public Classe modifier_classe(Long id, Classe c){
        c.setIdClasse(id);
        return cRepository.save(c);
    }

    public void supprimer_classe(Long id){
        cRepository.deleteById(id);
    }

    public List<Groupe> afficherGroupes(Long id){
        Classe c = rechercherUneClasse(id);
        return c.getGroupes();
    }

    public List<Enseignement> afficherEnseignements(Long id){
        Classe c = rechercherUneClasse(id);
        return c.getEnseignements();
    }

    public void ajouterGroupeDansClasse(Classe c, Groupe g) {
        c.getGroupes().add(g);
        g.setClasse(c); 
        gService.ajouterGroupe(g);
    }

    
}
