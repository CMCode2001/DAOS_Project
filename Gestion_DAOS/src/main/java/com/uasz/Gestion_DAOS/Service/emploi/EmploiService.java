package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.emploi.Emploi;
import com.uasz.Gestion_DAOS.Repository.emploi.EmploiRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmploiService {
    @Autowired
    private EmploiRepository repository;

    //AJOUTER 
    public Emploi ajouter_emploi(Emploi e){
        e.setDateCreationEmploi(new Date(System.currentTimeMillis()));
        e.setDateDebutEmploi(new Date(System.currentTimeMillis()));
        e.setDateFinEmploi(new Date(System.currentTimeMillis()));
        return repository.save(e);
    }

    //MODIFIER
    public Emploi modifier_emploi(Emploi e, Long idEmploi){
        e.setIdEmploi(idEmploi);
        return repository.save(e);
    }

    //RECHERCHER
    public Emploi recherche_emploi(Long idEmploi) {
      return repository.findById(idEmploi).get();
    }
    //SUPPRIMER
    public void supprimer_emploi(Long idEmploi){
        repository.deleteById(idEmploi);
    }

    //LISTER TOUT ATTRIBUT
    public List<Emploi> listerToutEmploi() {
       return repository.findAll();
    }
}
