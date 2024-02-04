package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Groupe;
import com.uasz.Gestion_DAOS.Repository.maquette.GroupeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class GroupeService {
    @Autowired
    private GroupeRepository gRepository;

    public void ajouterGroupe(Groupe g){
        g.setDateCreationGroupe(new Date(System.currentTimeMillis()));
        gRepository.save(g);
    }

    public List<Groupe> rechercherGroupes(){
        return gRepository.findAll();
    }

    public Groupe rechercherUneGroupe(Long idGroupe){
        return gRepository.findById(idGroupe).get();
    }

    public Groupe modifierGroupe(Groupe newGroupe){
        Groupe g = rechercherUneGroupe(newGroupe.getIdGroupe());
        g.setLibelleGroupe(newGroupe.getLibelleGroupe());
        g.setNumeroGroupe(newGroupe.getNumeroGroupe());
        g.setEffectifGroupe(newGroupe.getEffectifGroupe());
        g.setDescriptionGroupe(newGroupe.getDescriptionGroupe());
        return gRepository.save(g);
    }

    public void supprimerGroupe(Groupe g){
        gRepository.delete(g);
    }

    public Groupe ajouter_groupe( Groupe g){
        g.setDateCreationGroupe(new Date(System.currentTimeMillis()));
        return gRepository.save(g);
    }

    public Groupe modifier_groupe(Groupe g, Long id){
        g.setIdGroupe(id);
        return gRepository.save(g);
    }

    public void supprimer_groupe(Long id){
        gRepository.deleteById(id);
    }
}
