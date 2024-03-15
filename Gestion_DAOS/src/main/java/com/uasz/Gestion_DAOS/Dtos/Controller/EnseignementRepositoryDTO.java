package com.uasz.Gestion_DAOS.Dtos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Dtos.Model.EnseignementDTO;
import com.uasz.Gestion_DAOS.Dtos.Service.EnseignementServiceDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/enseignements")
public class EnseignementRepositoryDTO {
    @Autowired
    private EnseignementServiceDTO eService;

    @GetMapping
    public List<EnseignementDTO> lister_Enseignement(){
        return eService.lister_EnseignementDTO();
    }
 
}
