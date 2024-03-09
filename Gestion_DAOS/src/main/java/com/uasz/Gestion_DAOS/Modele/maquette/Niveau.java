package com.uasz.Gestion_DAOS.Modele.maquette;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uasz.Gestion_DAOS.Modele.Constante.NiveauConst;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    private String libelleNiveau;
    private String descriptionNiveau;
    @Temporal(TemporalType.DATE)
    private Date dateCreationNiveau;

    /**
     * Representation de la relation Niveau-Cycle;
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cycle")
    private Cycle cycle;

    /**
     * Representation de la relation Niveau-Formation;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private List <Formation> formations;
}