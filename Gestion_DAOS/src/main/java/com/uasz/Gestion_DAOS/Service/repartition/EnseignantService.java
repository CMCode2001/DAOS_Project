package com.uasz.Gestion_DAOS.Service.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Repository.repartition.EnseignantRepository;
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
    
}