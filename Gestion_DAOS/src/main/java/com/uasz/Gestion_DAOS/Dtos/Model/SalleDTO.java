package com.uasz.Gestion_DAOS.Dtos.Model;

import com.uasz.Gestion_DAOS.Modele.emploi.Salle;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalleDTO {
    
    private Long idSalle;
    private String salle;
    private String codeSalle;
    private int capacite;
    private Long idBatiment;
    private String batiment;
    private String position;
    // public SalleDTO(Salle s){
    //     this.idSalle=s.getIdSalle();
    //     this.salle=s.getLibelleSalle();
        

    // }

}
