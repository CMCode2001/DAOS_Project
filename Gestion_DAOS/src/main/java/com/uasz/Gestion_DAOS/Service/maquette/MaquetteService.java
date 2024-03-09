package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Formation;
import com.uasz.Gestion_DAOS.Modele.maquette.Maquette;
import com.uasz.Gestion_DAOS.Modele.maquette.Module;
import com.uasz.Gestion_DAOS.Repository.maquette.MaquetteRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class MaquetteService {
    @Autowired
    private MaquetteRepository mRepository;

    public void ajouterMaquette(Maquette m){
        m.setDateCreationMaquette(new Date(System.currentTimeMillis()));
        mRepository.save(m);
    }

    public List<Maquette> rechercherMaquettes(){
        return mRepository.findAll();
    }

    public Maquette rechercherUneMaquette(Long idMaq){
        return mRepository.findById(idMaq).get();
    }

    public Maquette modifierMaquette(Maquette newMaquette, Long idMaq){
        Maquette m = rechercherUneMaquette(idMaq);
        m.setLibelleMaquette(newMaquette.getLibelleMaquette());
        m.setCodeMaquette(newMaquette.getCodeMaquette());
        return mRepository.save(m);
    }

    public void supprimerMaquette(Long idMaq){
        mRepository.delete(rechercherUneMaquette(idMaq));
    }

    public Maquette ajouter_maquette( Maquette m ){
        m.setDateCreationMaquette(new Date(System.currentTimeMillis()));
        return mRepository.save(m);
    }

    public Maquette modifier_maquette(Maquette m , Long id){
        m.setIdMaquette(id);
        return mRepository.save(m);
    }

    public void supprimer_maquette(Long id){
        mRepository.deleteById(id);
    }

    public List<Module> afficherModules(Long id){
        Maquette m = rechercherUneMaquette(id);
        return m.getModules();
    }

    public Formation afficherFormation(Long id){
        Maquette m = rechercherUneMaquette(id);
        return m.getFormation();
    }
}
