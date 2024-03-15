package com.uasz.Gestion_DAOS.Modele.maquette;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;
    private String libelleFormation;
    private String descriptionFormation;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFormation;

    /**
     * Representation de la relation Maquette-Formation
     */
    @OneToOne(mappedBy = "formation")
    private Maquette maquette;

    /**
    * Representation de la relation Filiere-Formation;
    */
    @JoinColumn(name = "filiere")
    @ManyToOne
    private Filiere filiere;
    /** 
    * Representation de la relation Formation-Niveau;
    */
    @JoinColumn(name= "niveau")
    @ManyToOne
    private Niveau niveau;

    /**
     * Representation de la relation Formation-Classe;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;

}
