package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
