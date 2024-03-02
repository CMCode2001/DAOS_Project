package com.uasz.Gestion_DAOS.Modele.emploi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBatiment;
    private String libelleBatiment;
    private String codeBatiment;
    private String positionBatiment;
    private String descriptionBatiment;
    @Temporal(TemporalType.DATE)
    private Date dateCreationBatiment;
    
    /**
     * Representation de la relation Batiment-Salle
     */
    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL)
    private List<Salle> salles = new ArrayList<>();
}
