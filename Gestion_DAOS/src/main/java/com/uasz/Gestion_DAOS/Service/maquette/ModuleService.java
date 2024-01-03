package com.uasz.Gestion_DAOS.Service.maquette;

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

    public void ajouterModule(Module f){
        mRepository.save(f);
    }

    public List<Module> rechercherModules(){
        return mRepository.findAll();
    }

    public Module rechercherUnModule(Long idMod){
        return mRepository.findById(idMod).get();
    }

    public Module modifierModule(Module newModule, Long idMod){
        Module m = rechercherUnModule(idMod);
        return mRepository.save(m);
    }

    public void supprimerModule(Long idMod){
        mRepository.delete(rechercherUnModule(idMod));
    }
}
