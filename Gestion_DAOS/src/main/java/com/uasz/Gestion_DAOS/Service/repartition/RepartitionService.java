package com.uasz.Gestion_DAOS.Service.repartition;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Repository.repartition.RepartitionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RepartitionService {
      @Autowired
    private RepartitionRepository repository;

    // public void ajouterRepartition(Repartition r ){
    //     r.setDateCreationRepartition(new Date(System.currentTimeMillis()));
    //     repository.save(r);

    // }
    public Repartition ajouter_repartition(Repartition r){
        r.setDateCreationRepartition(new Date(System.currentTimeMillis()));
        return repository.save(r);
    }
    
    public List<Repartition> listerToutRepartition(){
        return repository.findAll();
    }

    public Repartition rechercherRepartition(Long id){
        return repository.findById(id).get();
    }

    public Repartition modifierRepartition(Repartition r){
        Repartition updateRepartition = rechercherRepartition(r.getIdRepartition());
        updateRepartition.setDescriptionRepartition(r.getDescriptionRepartition());
        return repository.save(updateRepartition);
    }

    public void supprimerRepartition(Repartition r){
        repository.delete(r);
    }


    public Repartition modifier_repartition(Repartition r, Long id){
        r.setIdRepartition(id);
        return repository.save(r);
    }

    public void supprimer_repartition(Long id){
        repository.deleteById(id);
    }
}
