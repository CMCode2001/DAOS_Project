package com.uasz.Gestion_DAOS.Service.maquette;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Modele.maquette.EC;
import com.uasz.Gestion_DAOS.Modele.maquette.UE;
import com.uasz.Gestion_DAOS.Repository.maquette.ECRepository;
import com.uasz.Gestion_DAOS.Repository.maquette.UERepository;
import com.uasz.Gestion_DAOS.Modele.maquette.Module;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class UEService {
    @Autowired
    private UERepository ueRepository;

    @Autowired
    private ECService ecService;

    @Autowired ModuleService mService;

    public void ajouterUE(UE ue){
        UE savedUE = ueRepository.save(ue);
        savedUE.setDateCreationUE(new Date(System.currentTimeMillis()));
        ueRepository.save(savedUE);
    }

    public List<UE> listerToutUE(){
        return ueRepository.findAll();
    }

    public UE rechercherUE(Long idUE){
        return ueRepository.findById(idUE).get();
    }

    public UE modifierUE(UE ue){
        UE ueModifier = rechercherUE(ue.getIdUE());
        ueModifier.setLibelleUE(ue.getLibelleUE());
        ueModifier.setCodeUE(ue.getCodeUE());
        ueModifier.setCoefficientUE(ue.getCoefficientUE());
        ueModifier.setCreditUE(ue.getCreditUE());
        ueModifier.setCreditUE(ue.getCreditUE());
        ueModifier.setDescriptionUE(ue.getDescriptionUE());
        return ueRepository.save(ueModifier);
    }

    public void supprimerUE(UE ue){
        ueRepository.delete(ue);
    }

    /*public List<EC> afficherLesECs(UE ue){
        return ueRepository.findByUE(ue);
    }*/

    public List<EC> afficherLesECs(Long id){
       UE ue =  rechercherUE(id);
       return ue.getEcs();
    }

    public UE modifier_UE(UE ue, Long id){
        ue.setIdUE(id);
        return ueRepository.save(ue);
    }

    public void supprimer_UE(Long id){
        ueRepository.deleteById(id);
    }
    
    public UE ajouter_UE(UE ue){
        UE savedUE = ueRepository.save(ue);
        savedUE.setDateCreationUE(new Date(System.currentTimeMillis()));
        return ueRepository.save(savedUE);
    }



    public void ajouterECdansUE(EC ec, UE ue) {
        ue.getEcs().add(ec); 
        ec.setUe(ue); 
        ecService.ajouterEC(ec);
    }

    public void ajouterModuleDansUE(Module module, UE ue) {
        ue.getModules().add(module); 
        module.setUe(ue); 
        mService.ajouterModule(module);
    }
    
    public List<Module> afficherModules(Long id){
        UE ue = rechercherUE(id);
        return ue.getModules();
    }

}