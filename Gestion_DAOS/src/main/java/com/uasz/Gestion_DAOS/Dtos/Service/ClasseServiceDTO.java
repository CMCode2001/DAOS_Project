package com.uasz.Gestion_DAOS.Dtos.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Dtos.Model.ClasseDTO;
import com.uasz.Gestion_DAOS.Modele.maquette.Classe;
import com.uasz.Gestion_DAOS.Service.maquette.ClasseService;

@Service
public class ClasseServiceDTO {
    @Autowired
    private ClasseService classeService;

   public List<ClasseDTO> listerClasseDTOs(){
        List<Classe> classes = classeService.rechercherLesClasses();
        List<ClasseDTO> classseDTOs = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            ClasseDTO classeDTO = new ClasseDTO();
            classeDTO.setIdClasse(classes.get(i).getIdClasse());
            classeDTO.setClasse(classes.get(i).getLibelleClasse());
            classeDTO.setEffectif(classes.get(i).getEffectifClasse());

            if (classes.get(i).getSemestre() !=null) {
                classeDTO.setSemestre(classes.get(i).getSemestre().getLibelleSemestre());
            }
            classeDTO.setFormation(classes.get(i).getFormation().getLibelleFormation());
            

            classseDTOs.add(classeDTO);
        }

        return classseDTOs;
   }

}
