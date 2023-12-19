package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String libelleFormation;
    private String descriptionFormation;

    /**
     * Representation de la relation Maquette-Formation
     */
    @OneToOne(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Maquette maquette;

    /**
    * Representation de la relation Filiere-Formation;
    */
    @ManyToOne
    @JoinColumn(name = "filiere")
    private Filiere filiere;
    /** 
    * Representation de la relation Formation-Niveau;
    */
    @ManyToOne
    @JoinColumn(name= "niveau")
    private Niveau niveau;

    /**
     * Representation de la relation Formation-Classe;
     */

    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;

}
