package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.Classe;
import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;
import com.uasz.Gestion_DAOS.Modele.maquette.Module;
import com.uasz.Gestion_DAOS.Repository.maquette.ModuleRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ModuleService {
    @Autowired
    private ModuleRepository mRepository;

    public void ajouterModule(Module m){
        m.setDateCreationModule(new Date(System.currentTimeMillis()));
        mRepository.save(m);
    }

    public List<Module> rechercherModules(){
        return mRepository.findAll();
    }

    public Module rechercherUnModule(Long idMod){
        return mRepository.findById(idMod).get();
    }

    public Module modifierModule(Module newModule){
        Module m = rechercherUnModule(newModule.getIdModule());
        m.setLibelleModule(newModule.getLibelleModule());
        m.setCoursModule(newModule.getCoursModule());
        m.setDureeModule(newModule.getDureeModule());
        m.setObjectifsModule(newModule.getObjectifsModule());
        m.setDescriptionModule(newModule.getDescriptionModule());
        return mRepository.save(m);
    }

    public void supprimerModule(Module m){
        mRepository.delete(m);
    }

    public Module ajouter_module(Module m){
        m.setDateCreationModule(new Date(System.currentTimeMillis()));
        return mRepository.save(m);
    }

    public Module modifier_module(Module m, Long id){
        m.setIdModule(id);
        return mRepository.save(m);
    }

    public void supprimer_module(Long id){
        mRepository.deleteById(id);
    }

    public Optional<Module> rechercherModuleParLibelle(String libelle){
        return mRepository.findByLibelleModule(libelle);
    }

    public List<Enseignement> afficherEnseignements(Long id){
        Module m = rechercherUnModule(id);
        return m.getEnseignements();
        
    }
}
