package com.uasz.Gestion_DAOS.Service.repartition;

import com.uasz.Gestion_DAOS.Modele.repartition.Enseignant;
import com.uasz.Gestion_DAOS.Repository.repartition.EnseignantRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Data
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    /**
     *  Methode ajouter un enseignant
     * @param enseignant
     * @return Enseignant
     */
    public Enseignant ajouterEnseignant(Enseignant enseignant){
        return enseignantRepository.save(enseignant);

    }

    /**
     * Methode permettant de lister tous les Enseignants
     * @return {@code List<UE>}
     */
    public List<Enseignant> listerToutEnseignant(){
        return enseignantRepository.findAll();
    }

    /**
     * Methode permettant de trouver un Enseignant de par son ID
     * @param idEnseignant
     * @return {@code Optional} contenant l'Enseignant trouve, ou {@code Optional.empty()} si aucun Ensignant est trouve;
     */
    public Optional<Enseignant> searchEnseignant(Long idEnseignant){
        return enseignantRepository.findById(idEnseignant);
    }

    /**
     * Methode permettant de modifier un Enseignant
     * @param enseignant
     * @return {@Code Enseignant} la nouvelle Enseignant modifier ou, {@code new RuntimeException()} si l'Enseignant n'existe pas
     */
//    public Enseignant modifierEns(Enseignant enseignant){
//        Optional<Enseignant> ensModif = searchEnseignant(enseignant.getIdEns());
//        if(ensModif.isPresent()) {
//            ensModif.orElseThrow().setIdEns(enseignant.getIdEns());
//            ensModif.orElseThrow().setNomEns(enseignant.getNomEns());
//            ensModif.orElseThrow().setPrenomEns(enseignant.getPrenomEns());
//            ensModif.orElseThrow().setGradeEns(enseignant.getGradeEns());
//            return enseignantRepository.save(ensModif.get());
//        }
//        else{
//            // Gérer le cas où l'Enseignant n'est pas trouvée
//            throw new RuntimeException("Enseignant non trouvée avec l'ID : " + enseignant.getIdEns());
//        }
//
//    }
    /**
     * Methode permettant de supprimer un Enseignant;
     *
     * @param idEns
     * @return
     */
    public void deleteEns(Long idEns){
        enseignantRepository.deleteById(idEns);
    }
}