package com.uasz.Gestion_DAOS.Service.repartition;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.repartition.Vacataire;
import com.uasz.Gestion_DAOS.Repository.repartition.VacataireRepository;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class VacataireService {
    @Autowired
    private VacataireRepository vacataireRepository;

    public Vacataire ajouter_vacataire(Vacataire vac){
        vac.setDateCreationEns(new Date(System.currentTimeMillis()));
        return vacataireRepository.save(vac);
        
    }

    public List<Vacataire> lister_vacataires(){
        return vacataireRepository.findAll();
    }

    public Vacataire rechercherVac(Long id){
        return vacataireRepository.findById(id).get();
    }

    public Vacataire modifierVac(Vacataire vac){
        Vacataire vac1=rechercherVac(vac.getIdEns());
        vac1.setIdEns(vac.getIdEns());
        vac1.setSpecialite(vac.getSpecialite());
        vac1.setNomEns(vac.getNomEns());
        vac1.setPrenomEns(vac.getPrenomEns());
        vac1.setGradeEns(vac.getGradeEns());
        return vacataireRepository.save(vac1);
    }

    public void supprimerVac(Vacataire vac){
        Vacataire vac1=rechercherVac(vac.getIdEns());
        vacataireRepository.delete(vac);
    }

    public Vacataire modifier_vacataire(Vacataire vacataire, Long id){
        vacataire.setIdEns(id);
        return vacataireRepository.save(vacataire);
    }
    public void supprimer_vacataire(Long id){
        vacataireRepository.deleteById(id);
    }
}