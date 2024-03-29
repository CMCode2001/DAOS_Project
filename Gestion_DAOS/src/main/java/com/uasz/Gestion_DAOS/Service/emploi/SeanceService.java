package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.emploi.Deroulement;
import com.uasz.Gestion_DAOS.Modele.emploi.Salle;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Repository.emploi.SeanceRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Transactional
@AllArgsConstructor
public class SeanceService {
     @Autowired
    private SeanceRepository seanceRepository ;

    @Autowired
    private DeroulementService dService;

    //AJOUTER 
    public Seance ajouter_Seance(Seance seance){
        Seance savedSeance = seanceRepository.save(seance);
        savedSeance.setDateCreationSeance(new Date(System.currentTimeMillis()));
        return seanceRepository.save(savedSeance);
    }

    //MODIFIER
    public Seance modifier_Seance(Seance seance, Long idSeance){
        seance.setIdSeance(idSeance);
        return seanceRepository.save(seance);
    }

    //RECHERCHER
    public Seance recherche_Seance(Long idSeance) {
      return seanceRepository.findById(idSeance).get();
    }
    //SUPPRIMER
    public void supprimer_Seance(Long id){
        seanceRepository.deleteById(id);
    }

    //LISTER TOUT ATTRIBUT
    public List<Seance> listerToutSeance() {
       return seanceRepository.findAll();
    }

    public Seance updatSeance(Seance s){
        return seanceRepository.save(s);
    }

    public Salle salle_assigner(Long id){
        Seance s = recherche_Seance(id);
        return s.getSalle();
    }

    public void ajouter_Deroulement(Deroulement d, Seance s){
        s.setDeroulement(d);
        d.setSeance(s);
        dService.ajouter_Deroulement(d);
        seanceRepository.save(s);
    }
}