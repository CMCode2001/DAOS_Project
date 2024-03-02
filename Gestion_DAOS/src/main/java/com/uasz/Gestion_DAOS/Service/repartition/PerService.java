package com.uasz.Gestion_DAOS.Service.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.PER;
import com.uasz.Gestion_DAOS.Repository.repartition.PerRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data
public class PerService {
    @Autowired
    private PerRepository perRepository;

    /**
     *  Methode ajouter un PER
     * @param per
     * @return per
     */
    public PER ajouterPer(PER per){
        per.setDateCreationEns(new Date(System.currentTimeMillis()));
        return perRepository.save(per);

    }

    /**
     * Methode permettant de lister tous les PERs
     * @return {@code List<PER>}
     */
    public List<PER> listerToutPER(){
        return perRepository.findAll();
    }

    /**
     * Methode permettant de trouver un PER de par son ID
     * @param idPer
     * @return {@code Optional} contenant le PER trouve, ou {@code Optional.empty()} si aucun PER est trouve;
     */
    public PER searchPer(Long idPer){
        return perRepository.findById(idPer).get();
    }

    /**
     * Methode permettant de modifier un PER
     * @param per
     * @return {@Code PER} la nouvelle PER modifier ou, {@code new RuntimeException()} si l'PER n'existe pas
     */
    public PER modifierEns(PER per){
        PER perModif = searchPer(per.getIdEns());
    
            perModif.setMatriculePer(per.getMatriculePer());
            perModif.setNomEns(per.getNomEns());
            perModif.setPrenomEns(per.getPrenomEns());
            perModif.setGradeEns(per.getGradeEns());
            return perRepository.save(perModif);
    }
    /**
     * Methode permettant de supprimer un PER;
     *
     * @param id
     * @return
     */
    public void deletePer(Long id){
        perRepository.deleteById(id);
    }

    public PER modifier_per(PER p, Long id){
        p.setIdEns(id);
        return perRepository.save(p);
    }
    
}
