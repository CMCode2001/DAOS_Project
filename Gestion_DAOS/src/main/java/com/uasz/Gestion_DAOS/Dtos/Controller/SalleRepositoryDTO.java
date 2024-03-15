package com.uasz.Gestion_DAOS.Dtos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Dtos.Model.SalleDTO;
import com.uasz.Gestion_DAOS.Dtos.Service.SalleServiceDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/salles")
public class SalleRepositoryDTO {
    @Autowired
    private SalleServiceDTO salleServiceDto;
    
    @GetMapping
    public List<SalleDTO> lister_SalleDTOs(){
        return salleServiceDto.lister_SalleDTOs();
    }
}
