package com.uasz.Gestion_DAOS.Service.emploi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
import com.uasz.Gestion_DAOS.Repository.emploi.SeanceRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Transactional
@Data
public class SeanceService {
     @Autowired
    private SeanceRepository seanceRepository ;

    //AJOUTER 
    public Seance ajouter_Seance(Seance seance){
        Seance savedSeance = seanceRepository.save(seance);
        savedSeance.setDateCreationSeance(new Date(System.currentTimeMillis()));
        return seanceRepository.save(savedSeance);
    }

    //MODIFIER
    public Seance modifier_Seance(Seance Seance, Long idSeance){
        Seance.setIdSeance(idSeance);
        return seanceRepository.save(Seance);
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
}
