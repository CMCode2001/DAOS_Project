package com.uasz.Gestion_DAOS.Dtos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Dtos.Model.ClasseDTO;
import com.uasz.Gestion_DAOS.Dtos.Service.ClasseServiceDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/classes")
public class ClasseRepositoryDTO {
    @Autowired
    private ClasseServiceDTO classeServiceDTO;
    
    @GetMapping
    public List<ClasseDTO> lister_classeDTOs(){
        return classeServiceDTO.listerClasseDTOs();
    }
}
