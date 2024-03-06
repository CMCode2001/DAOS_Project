package com.uasz.Gestion_DAOS.Service.repartition;


import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;
import com.uasz.Gestion_DAOS.Repository.repartition.EnseignantRepository;
import com.uasz.Gestion_DAOS.Repository.repartition.RepartitionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private RepartitionService rService;

    @PersistenceContext
    private EntityManager entityManager;

    public Enseignant ajouter_enseignant(Enseignant ens){
        ens.setDateCreationEns(new Date(System.currentTimeMillis()));
        return enseignantRepository.save(ens);
    }

    public  List<Enseignant> lister_enseignant(){
        return enseignantRepository.findAll();
    }

    public Enseignant rechercher_enseignant(Long id){
        return enseignantRepository.findById(id).get();
    }

    public Enseignant modifier_enseignant(Enseignant ens, Long id){
        ens.setIdEns(id);
        return enseignantRepository.save(ens);
    }

    public void supprimer_enseignant(Long id){
        enseignantRepository.deleteById(id);
    }
    
    public void ajouterRepartitionPourEnseignant(Long idEnseignant, Repartition repartition) {
        Enseignant enseignant = enseignantRepository.findById(idEnseignant).orElse(null);
        if (enseignant != null) {
            repartition.setDateCreationRepartition(new Date(System.currentTimeMillis()));
            repartition.setEnseignant(enseignant);
            // Vous pouvez également ajouter d'autres logiques ici avant de sauvegarder la répartition
            enseignant.getRepartitions().add(repartition);
            enseignantRepository.save(enseignant);
        } else {
            // Gérer le cas où l'enseignant n'est pas trouvé
            System.out.println("L'enseignant avec l'ID " + idEnseignant + " n'existe pas.");
        }
    }
    

    public List<Repartition> obtenirRepartitionsPourEnseignant(Long idEnseignant) {
        Enseignant enseignant = enseignantRepository.findById(idEnseignant).orElse(null);
        if (enseignant != null) {
            return enseignant.getRepartitions();
        } else {
            // Gérer le cas où l'enseignant n'est pas trouvé
            System.out.println("L'enseignant avec l'ID " + idEnseignant + " n'existe pas.");
            return null;
        }
    }
}