package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Repository.emploi.SalleRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    //AJOUTER 
    public Salle ajouter_Salle(Salle salle){
        Salle savedSalle = salleRepository.save(salle);
        savedSalle.setDateCreationSalle(new Date(System.currentTimeMillis()));
        return salleRepository.save(savedSalle);
    }

    //MODIFIER
    public Salle modifier_Salle(Salle salle, Long idSalle){
        salle.setIdSalle(idSalle);
        return salleRepository.save(idSalle);
    }

    //RECHERCHER
    public Salle recherche_Salle(Long idSalle) {
      return salleRepository.findById(idSalle).get();
    }
    //SUPPRIMER
    public void supprimer_Salle(Long idSalle){
        salleRepository.deleteById(idSalle);
    }

    //LISTER TOUT ATTRIBUT
    public List<Salle> listerToutSalle() {
       return salleRepository.findAll();
    }
}
