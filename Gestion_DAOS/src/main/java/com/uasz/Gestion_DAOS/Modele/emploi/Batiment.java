package com.uasz.Gestion_DAOS.Modele.emploi;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String nomBatiment;
    private String Nb_Etage;
    private Year   anneeBatiment;
    private String typeBatiment;
    
    /**
     * Representation de la relation Batiment-Salle
     */
    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salle> salles = new ArrayList<>();
}
