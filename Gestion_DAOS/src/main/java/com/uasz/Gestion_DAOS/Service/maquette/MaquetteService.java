package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Maquette;
import com.uasz.Gestion_DAOS.Repository.maquette.MaquetteRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class MaquetteService {
    @Autowired
    private MaquetteRepository mRepository;

    public void ajouterMaquette(Maquette f){
        mRepository.save(f);
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
}
