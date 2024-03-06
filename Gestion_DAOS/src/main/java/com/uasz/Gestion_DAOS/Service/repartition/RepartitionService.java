package com.uasz.Gestion_DAOS.Service.repartition;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Repository.repartition.RepartitionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RepartitionService {
    @Autowired
    private RepartitionRepository repository;
    @Autowired
    private PerService perService;
    @Autowired
    private VacataireService vService;

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

    public Repartition rechercherRepartitionParId(Long id) {
        Optional<Repartition> optionalRepartition = repository.findById(id);
        if (optionalRepartition.isPresent()) {
            return optionalRepartition.get();
        } else {
            return null;
        }
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

   /* //ajouter un enseignant dans un reppartition
    public void ajouterEnseignantPerARepartition(Repartition r, PER p){
        r.setEnseignant(p);
        p.getRepartitions().add(r);
        perService.ajouterPer(p);
    }

    //ajouter un Enseignant Vacataire dans Repartition
    public void ajouterEnseignantVacataireARepartition(Repartition r, Vacataire v){
        r.setEnseignant(v);
        v.getRepartitions().add(r);
        vService.ajouter_vacataire(v);
    }

    */
    // Service qui affiche tous les enseignants d'une repartion donnee
}


