package com.uasz.Gestion_DAOS.Service.maquette;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Cycle;
import com.uasz.Gestion_DAOS.Modele.maquette.Niveau;
import com.uasz.Gestion_DAOS.Repository.maquette.CycleRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CycleService {
    @Autowired
    private CycleRepository cRepository;

    public void ajouterCycle(Cycle c){
        c.setDateCreationCycle(new Date(System.currentTimeMillis()));
        cRepository.save(c);
    }

    public  List<Cycle> rechercheTousCycles(){
        return  cRepository.findAll();
    }

    public Cycle rechercherUnCycle(Long idCycle){
        return cRepository.findById(idCycle).get();
    }

    public Cycle modifierCycle(Cycle c){
        Cycle cycle = rechercherUnCycle(c.getIdCycle());
        cycle.setLibelleCycle(c.getLibelleCycle());
        cycle.setDescriptionCycle(c.getDescriptionCycle());
        return cRepository.save(cycle);
    }

    public void supprimerCycle(Cycle c){
        cRepository.delete(c);
    }

    public Cycle ajouter_cycle(Cycle c){
        c.setDateCreationCycle(new Date(System.currentTimeMillis()));
        return cRepository.save(c);
    }
    
    public Cycle modifier_cycle(Long id, Cycle c){
        c.setIdCycle(id);
        return cRepository.save(c);
    }

    public void supprimer_cycle(Long id){
        cRepository.deleteById(id);
    }

    public List<Niveau> afiicherNiveaux(Long id){
        Cycle c = rechercherUnCycle(id);
        return c.getNiveaux();
    }

}

