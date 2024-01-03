package com.uasz.Gestion_DAOS.Service.maquette;

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
        gRepository.save(g);
    }

    public List<Groupe> rechercherGroupes(){
        return gRepository.findAll();
    }

    public Groupe rechercherUneGroupe(Long idGroupe){
        return gRepository.findById(idGroupe).get();
    }

    public Groupe modifierGroupe(Groupe newGroupe, Long idGroupe){
        Groupe g = rechercherUneGroupe(idGroupe);
        g.setNomGroupe(newGroupe.getNomGroupe());
        g.setEffectifGroupe(newGroupe.getEffectifGroupe());

        return gRepository.save(g);
    }

    public void supprimerGroupe(Long idGroupe){
        gRepository.delete(rechercherUneGroupe(idGroupe));
    }
}
