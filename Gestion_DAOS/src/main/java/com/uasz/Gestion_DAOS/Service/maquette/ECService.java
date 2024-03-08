package com.uasz.Gestion_DAOS.Service.maquette;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.Module;
import com.uasz.Gestion_DAOS.Repository.maquette.ECRepository;

import groovy.util.ResourceException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ECService {
    @Autowired
    private ECRepository ecRepository;

    @Autowired
    private ModuleService moduleService;

    public void ajouterEC(EC ec){
        ec.setDateCreationEC(new Date(System.currentTimeMillis()));
        ecRepository.save(ec);
    }

    public List<EC> rechercherTousEC(){
        return ecRepository.findAll();
    }

    public EC rechercherEc(Long idEC){
        return ecRepository.findById(idEC).get();
    }

    public EC modifierEC(EC newEC){
        EC ecModifier = rechercherEc(newEC.getIdEC());
        ecModifier.setCodeEC(newEC.getCodeEC());
        ecModifier.setLibelleEC(newEC.getLibelleEC());
        ecModifier.setCoefficientEC(newEC.getCoefficientEC());
        ecModifier.setCm(newEC.getCm());
        ecModifier.setTd(newEC.getTd());
        ecModifier.setTp(newEC.getTp());
        ecModifier.setTpe(newEC.getTpe());
        ecModifier.setDescritptionEC(newEC.getDescritptionEC());
        return ecRepository.save(ecModifier);
    }
    
    public void supprimerEC(EC ec){
        ecRepository.delete(ec);
    }

    public EC ajouter_ec( EC ec){
        ec.setDateCreationEC(new Date(System.currentTimeMillis()));
        return ecRepository.save(ec);
    }

    public EC modifier_ec(EC ec, Long id){
        ec.setIdEC(id);
        return ecRepository.save(ec);
    }

    public void supprimer_ec(Long id){
        ecRepository.deleteById(id);
    }

    public EC addModuleToEC(Long idEC, Module module) {
        EC ec = ecRepository.findById(idEC).get();
        module.setEc(ec);
        ec.getModules().add(module); // Add module directly to the EC's list
        return ecRepository.save(ec); // Save the entire EC object
    }

    public List<Module> getModulesByEC(Long idEC) {
        EC ec = ecRepository.findById(idEC).get();
        return ec.getModules();
    }

}
